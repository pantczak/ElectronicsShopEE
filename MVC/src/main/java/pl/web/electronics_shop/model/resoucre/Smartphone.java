package pl.web.electronics_shop.model.resoucre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Smartphone extends Resource {
    @NotNull
    @Size(min = 1, max = 36)
    private double batteryLifetime;

    public Smartphone(String brand, String model, boolean isAvailable, int weightInGrams, double batteryLifetime) {
        super(brand, model, isAvailable, weightInGrams);
        this.batteryLifetime = batteryLifetime;
    }


}
