package tacos.repository;

import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;

import java.util.Optional;

/**
 * todo Document type IngredientRepository
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
