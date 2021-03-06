package pl.web.electronics_shop.repository;

import pl.web.electronics_shop.model.Event;

public interface EventRepository extends RepositoryBase<Event> {
    void delete(Event event);
}
