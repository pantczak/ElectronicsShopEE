package pl.web.electronics_shop.service;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.repository.EventRepository;
import pl.web.electronics_shop.repository.ResourceRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RequestScoped
@NoArgsConstructor
public class ResourceService implements Serializable {

    @Inject
    ResourceRepository resourceRepository;

    @Inject
    EventRepository eventRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.getAll();
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

        eventRepository.getAll().stream().filter(event -> event.getDevice().
                equals(resourceRepository.get(resource.getUuid()))).forEach(event -> event.setDevice(null));

        resourceRepository.delete(resource);
    }


}
