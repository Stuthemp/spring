package tacos.utils;

import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.model.UDT.IngredientUDT;
import tacos.model.UDT.TacoUDT;

import java.util.List;
import java.util.stream.Collectors;

/**
 * todo Document type TacoUDRUtils
 */
public class TacoUDRUtils {

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

    public static List<IngredientUDT> toIngredientUDTs(List<Ingredient> ingredients) {
        return ingredients.stream()
            .map(ingredient -> toIngredientUDT(ingredient))
            .collect(Collectors.toList());
    }

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
