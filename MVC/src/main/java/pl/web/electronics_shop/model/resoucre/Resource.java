package pl.web.electronics_shop.model.resoucre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Resource {
    private String brand;
    private String model;
    private boolean isAvailable;
    private int weightInGrams;
}
