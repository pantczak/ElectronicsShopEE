package pl.web.electronics_shop.repository.implementation;

import pl.web.electronics_shop.model.Event;
import pl.web.electronics_shop.repository.EventRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InMemoryEventRepository implements EventRepository {
    private final List<Event> events;

    public InMemoryEventRepository() {
        events = new ArrayList<>();
    }

    @Override
    public synchronized void add(Event event) {
        if (get(event.getUuid()) == null) {
            events.add(event);
        }
    }

    @Override
    public synchronized Event get(UUID uuid) {
        return events.stream().filter(event -> event.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public synchronized List<Event> getAll() {
        return events;
    }

    @Override
    public synchronized void update(Event eventToUpdate) {
        events.stream().filter(event -> event.getUuid().equals(eventToUpdate.getUuid())).findFirst().
                ifPresent(event -> events.set(events.indexOf(event), eventToUpdate));
    }

    @Override
    public synchronized void delete(Event event) {
        if (get(event.getUuid()) != null) {
            events.remove(event);
        }

    }
}
