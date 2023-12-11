package com.resftul.desafio.service;

import com.resftul.desafio.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService extends OrderService {

    /*
    Valor básico do pedido (sem desconto) Frete
    1 - Abaixo de R$ 100.00 R$ 20.00
    2 - De R$ 100.00 até R$ 200.00 exclusive R$ 12.00
    3 - R$ 200.00 ou mais Grátis
    */

    /**
     * Calcula o frete com base no total do pedido.
     *
     * @param order Pedido a ser processado.
     * @return O valor do frete.
     */
    public static double shipment(Order order) {
        double total = total(order);

        if (total < 100)
            return total + 20;
        else if (total < 200)
            return total + 12;
        else
            return total;
    }
}
