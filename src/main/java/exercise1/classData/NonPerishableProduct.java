package exercise1.classData;

import java.time.LocalDate;

public class NonPerishableProduct extends Product{
    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double applyDiscount(double v, String summerDiscount){
        System.out.println(summerDiscount);
        return super.getPrice()-(super.getPrice() * (v/100));
    };
}
