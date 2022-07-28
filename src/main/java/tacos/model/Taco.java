package tacos.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * todo Document type Taco
 */
@Data
public class Taco {

    private Date createdAt = new Date();

    @NotNull
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public Taco(){}

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
