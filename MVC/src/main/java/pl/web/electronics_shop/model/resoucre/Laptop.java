package pl.web.electronics_shop.model.resoucre;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Resource {
    @NotNull
    @Size(min = 1, max = 32)
    private int memoryInGb;

    public Laptop(String brand, String model, boolean isAvailable, int weightInGrams, int memoryInGb) {
        super(brand, model, isAvailable, weightInGrams);
        this.memoryInGb = memoryInGb;
    }


}
