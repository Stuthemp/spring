package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.TacoOrder;

/**
 * todo Document type OrderRepository
 */

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
