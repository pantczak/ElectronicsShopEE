package pl.web.electronics_shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.user.Client;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
public class Event extends Entity {
    private Resource device;
    private final Client client;
    private final Date borrowDate;
    private Date returnDate;

    public Event(Resource device, Client client, Date borrowDate) {
        super();
        this.device = device;
        this.client = client;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public Event(Resource device, Client client) {
        this.device = device;
        this.client = client;
        this.borrowDate = new Date();
        this.returnDate = null;
    }


}
