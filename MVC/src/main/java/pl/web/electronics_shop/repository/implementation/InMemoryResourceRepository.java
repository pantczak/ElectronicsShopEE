package pl.web.electronics_shop.repository.implementation;

import pl.web.electronics_shop.exception.ObjectAlreadyStoredException;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.repository.ResourceRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InMemoryResourceRepository implements ResourceRepository {
    private final List<Resource> resources;

    public InMemoryResourceRepository() {
        this.resources = new ArrayList<>();
    }

    @Override
    public synchronized void add(Resource resource) {
        if (get(resource.getUuid()) == null) {
            resources.add(resource);
        }
    }

    @Override
    public synchronized Resource get(UUID uuid) {
        return resources.stream().filter(resource -> resource.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public synchronized List<Resource> getAll() {
        return resources;
    }

    @Override
    public synchronized void update(Resource resourceToUpdate) {
        resources.stream().filter(resource -> resource.getUuid().equals(resourceToUpdate.getUuid())).findFirst().
                ifPresent(resource -> resources.set(resources.indexOf(resource), resourceToUpdate));
    }

    @Override
    public synchronized void delete(Resource resource) {
        if (get(resource.getUuid()) != null) {
            resources.remove(resource);
        }
    }
}
