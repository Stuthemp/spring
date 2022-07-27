package tacos.repository;

import tacos.model.TacoOrder;

/**
 * todo Document type OrderRepository
 */
public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
