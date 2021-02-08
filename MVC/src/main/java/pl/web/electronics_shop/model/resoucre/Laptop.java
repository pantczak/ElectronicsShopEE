package pl.web.electronics_shop.model.resoucre;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Resource{
    private int memoryInGb;

    public Laptop(String brand, String model, boolean isAvailable, int weightInGrams, int memoryInGb) {
        super(brand, model, isAvailable, weightInGrams);
        this.memoryInGb = memoryInGb;
    }




}
