package pl.web.electronics_shop.model.resoucre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Smartphone extends Resource {
    private double batteryLifetime;

    public Smartphone(String brand, String model, boolean isAvailable, int weightInGrams, double batteryLifetime) {
        super(brand, model, isAvailable, weightInGrams);
        this.batteryLifetime = batteryLifetime;
    }


}
