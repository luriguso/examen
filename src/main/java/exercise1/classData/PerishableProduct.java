package exercise1.classData;

import java.time.LocalDate;

public class PerishableProduct extends Product{
    private LocalDate expirationDate;
    private boolean expired;

    public PerishableProduct(String name, double price, int quantity, LocalDate expiration) {
        super(name, price, quantity);
        this.expirationDate = expiration;
        this.expired = isDateExpiration(expiration);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public double applyDiscount(double v, String summerDiscount){
        return super.getPrice()-(super.getPrice() * ((v+2)/100));
    }

    public boolean isDateExpiration(LocalDate expiration){
        return this.expirationDate.isAfter(expiration);
    }
}
