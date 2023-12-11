package com.resftul.desafio;

import com.resftul.desafio.entity.Order;
import com.resftul.desafio.service.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioInjecaoEInversaoDeDependenciaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioInjecaoEInversaoDeDependenciaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);
        Integer code = sc.nextInt();
        double basic = sc.nextDouble();
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);

        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor básico: " + salaryFormattedToReais(ShippingService.shipment(order)));

        sc.close();
    }

    /**
     * Formata um valor salarial para a moeda brasileira (Reais) no formato desejado.
     *
     * @param salary O valor salarial a ser formatado.
     * @return Uma string que representa o valor salarial formatado, utilizando o padrão brasileiro.
     */
    public static String salaryFormattedToReais(double salary) {
        Locale locale = new Locale("pt", "BR");

        // Use DecimalFormat para definir o padrão desejado com ponto como separador decimal
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
        symbols.setCurrencySymbol("R$ ");
        symbols.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00", symbols);

        return decimalFormat.format(salary);
    }
}
