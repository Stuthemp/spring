package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.model.TacoAppUser;
import tacos.model.TacoOrder;
import tacos.repository.OrderRepository;

import javax.validation.Valid;

/**
 * todo Document type OrderController
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal TacoAppUser user,
        @ModelAttribute TacoOrder order) {
        if (order.getDeliveryName() == null) {
            order.setDeliveryName(user.getFullname());
        }
        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(user.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }
        if (order.getDeliveryState() == null) {
            order.setDeliveryState(user.getState());
        }
        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(user.getZip());
        }

        return "orderForm";
    }


    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
        SessionStatus sessionStatus, @AuthenticationPrincipal TacoAppUser user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
