package pl.web.electronics_shop.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.Event;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.user.Client;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.EventRepository;
import pl.web.electronics_shop.repository.ResourceRepository;
import pl.web.electronics_shop.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
@NoArgsConstructor
@AllArgsConstructor
public class EventService implements Serializable {

    @Inject
    EventRepository eventRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    ResourceRepository resourceRepository;

    public void borrowResourceByLogin(UUID resourceUUID, String userLogin) {
        borrowResource(resourceUUID, userRepository.getByLogin(userLogin).getUuid(), new Date());
    }

    public void borrowResource(UUID resourceUuid, UUID userUuid) {
        borrowResource(resourceUuid, userUuid, new Date());
    }

    public void borrowResource(UUID resourceUuid, UUID userUuid, Date date) {
        Resource resource = resourceRepository.get(resourceUuid);
        User user = userRepository.get(userUuid);

        if (resource == null || user == null) return;

        if (!resource.isAvailable() || !(user instanceof Client) || !user.isActive()) return;

        eventRepository.add(new Event(resource, (Client) user, date));
        resource.setAvailable(false);
    }

    public void returnResource(Event event) {
        if (event == null || event.getReturnDate() != null || eventRepository.get(event.getUuid()) == null) return;
        endEvent(event);
        event.getResource().setAvailable(true);
    }

    private void endEvent(Event event) {
        eventRepository.get(event.getUuid()).setReturnDate(new Date());
    }

    public void deleteEvent(Event event) {
        if (event == null || event.getReturnDate() == null || eventRepository.get(event.getUuid()) == null) return;

        eventRepository.delete(event);
    }

    public Event getEvent(UUID uuid) {
        return eventRepository.get(uuid);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAll();
    }

    //TODO think about moving to EventRepository
    public List<Event> getEventsForClient(User client) {
        return getAllEvents().stream().filter(event -> event.getClient().equals(client)).
                collect(Collectors.toList());
    }

    //TODO think about moving to EventRepository
    public List<Event> getEventsForResource(Resource resource) {
        return getAllEvents().stream().filter(event -> event.getResource().equals(resource)).
                collect(Collectors.toList());
    }


}

