package pl.web.electronics_shop.repository;

import pl.web.electronics_shop.model.resoucre.Resource;

public interface ResourceRepository extends RepositoryBase<Resource> {
    void delete(Resource resource);
}
