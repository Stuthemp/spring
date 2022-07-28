package tacos.utils;

import org.springframework.stereotype.Component;
import tacos.model.Ingredient;
import tacos.model.UDT.IngredientUDT;
import tacos.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

/**
 * todo Document type StringToIngredientConverter
 */
@Component
public class StringToIngredientConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository ingredientRepository;

    public StringToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> {
            return new IngredientUDT(i.getName(), i.getType());
        }).get();
    }

}
