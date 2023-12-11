package com.resftul.desafio.service;

import com.resftul.desafio.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    /**
     * Calcula o total do pedido, levando em consideração o valor básico e o desconto percentual.
     *
     * @param order Pedido a ser processado.
     * @return O total do pedido.
     */
    public static double total(Order order) {
        double basic = order.getBasic();
        double discount = order.getDiscount();
        return basic - (discount * basic) / 100;
    }
}
