package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.repository.OrderRepository;

/**
 * todo Document type AdminService
 */
@Service
public class AdminService {

    OrderRepository orderRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
