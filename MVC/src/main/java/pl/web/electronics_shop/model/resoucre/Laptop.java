package pl.web.electronics_shop.model.resoucre;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Resource {
    @NotNull
    @Min(1)
    @Max(32)
    private int memoryInGb;

    public Laptop(String brand, String model, boolean isAvailable, int weightInGrams, int memoryInGb) {
        super(brand, model, isAvailable, weightInGrams);
        this.memoryInGb = memoryInGb;
    }


}
