package pl.web.electronics_shop.model.resoucre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.Entity;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Resource extends Entity {

    @NotNull
    @Size(min = 2, max = 20)
    private String brand;
    @NotNull
    @Size(min = 2, max = 20)
    private String model;
    @AssertTrue
    private boolean isAvailable;
    @NotNull
    @Size(min = 1)
    private int weightInGrams;
}
