package pl.web.electronics_shop.model;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class Entity {
    private UUID uuid;

    public Entity() {
        this.uuid = null;
    }
}
