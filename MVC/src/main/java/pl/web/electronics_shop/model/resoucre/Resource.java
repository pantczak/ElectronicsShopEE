package pl.web.electronics_shop.model.resoucre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Resource extends Entity {
    private String brand;
    private String model;
    private boolean isAvailable;
    private int weightInGrams;
}
