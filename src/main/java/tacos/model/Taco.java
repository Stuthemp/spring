package tacos.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * todo Document type Taco
 */
@Data
public class Taco {

    private Long id;
    private Date createdAt = new Date();
    @NonNull
    private String name;
    @NonNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients = new ArrayList<>();

    public Taco(){}

    public void addIngredient(Ingredient taco) {
        this.ingredients.add(new IngredientRef(taco.getId()));
    }

}
