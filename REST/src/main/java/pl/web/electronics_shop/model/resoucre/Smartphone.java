package pl.web.electronics_shop.model.resoucre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Smartphone extends Resource {
    @NotNull
    @Min(1)
    @Max(36)
    private double batteryLifetime;

    public Smartphone(String brand, String model, boolean isAvailable, int weightInGrams, double batteryLifetime) {
        super(brand, model, isAvailable, weightInGrams);
        this.batteryLifetime = batteryLifetime;
    }


}
