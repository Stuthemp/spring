package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.Taco;

/**
 * todo Document type TacoRepository
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
