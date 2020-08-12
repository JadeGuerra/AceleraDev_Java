package br.com.codenation.paymentmethods;

public class DebitCard implements PriceStrategy{


    @Override
    public Double calculate(Double price) {
         Double discount = 0.95;
        return price * discount;
    }
}
