package pl.web.electronics_shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.user.Client;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
public class Event extends Entity {
    private Resource resource;
    private final Client client;
    private final Date borrowDate;
    private Date returnDate;

    public Event(Resource resource, Client client, Date borrowDate) {
        super();
        this.resource = resource;
        this.client = client;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public Event(Resource resource, Client client) {
        this.resource = resource;
        this.client = client;
        this.borrowDate = new Date();
        this.returnDate = null;
    }


}
