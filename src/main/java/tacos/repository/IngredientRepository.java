package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;

import java.util.Optional;

/**
 * todo Document type IngredientRepository
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
