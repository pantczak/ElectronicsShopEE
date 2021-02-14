package pl.web.electronics_shop.service;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.resoucre.Smartphone;
import pl.web.electronics_shop.model.user.Admin;
import pl.web.electronics_shop.model.user.Employee;
import pl.web.electronics_shop.repository.EventRepository;
import pl.web.electronics_shop.repository.ResourceRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
@NoArgsConstructor
public class ResourceService implements Serializable {

    @Inject
    ResourceRepository resourceRepository;

    @Inject
    EventRepository eventRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.getAll();
    }

    public List<Laptop> getAllLaptops() {
        return resourceRepository.getAll().stream().filter(laptop -> laptop instanceof Laptop).
                map(laptop -> (Laptop) laptop).collect(Collectors.toList());
    }

    public List<Smartphone> getAllSmartphones() {
        return resourceRepository.getAll().stream().filter(smartphone -> smartphone instanceof Smartphone).
                map(smartphone -> (Smartphone) smartphone).collect(Collectors.toList());
    }


    public void addResource(Resource resource) {
        if (resource != null) {
            resourceRepository.add(resource);
        }
    }

    public Resource getResourceByUuid(UUID uuid) {
        return resourceRepository.get(uuid);
    }

    public void updateResource(Resource resource) {
        resourceRepository.update(resource);
    }

    public void deleteResource(Resource resource) {
        if (resourceRepository.get(resource.getUuid()) == null) return;

        if (!resourceRepository.get(resource.getUuid()).isAvailable()) return;

        eventRepository.getAll().stream().filter(event -> event.getResource().
                equals(resourceRepository.get(resource.getUuid()))).forEach(event -> event.setResource(null));

        resourceRepository.delete(resource);
    }


}
