package pl.web.electronics_shop.repository;

import pl.web.electronics_shop.exception.ObjectAlreadyStoredException;

import java.util.List;
import java.util.UUID;

public interface RepositoryBase<T> {
    void add(T t);

    T get(UUID uuid);

    List<T> getAll();

    void update(T t);
}
