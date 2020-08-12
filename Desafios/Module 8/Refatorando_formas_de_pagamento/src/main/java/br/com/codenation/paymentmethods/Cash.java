package br.com.codenation.paymentmethods;

public class Cash implements PriceStrategy {

    @Override
    public Double calculate(Double price) {
        Double discount = 0.9;
        return price * discount;
    }
}
