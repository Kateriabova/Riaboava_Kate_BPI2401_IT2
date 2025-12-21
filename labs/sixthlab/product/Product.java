package product;

import java.util.Objects;

public class Product {
    private String name;
    private int quantitySold;
    private double price;
    
    public Product(String name, double pricePerUnit) {
        this.name = name;
        this.price = pricePerUnit;
        this.quantitySold = 1;
    }
    
    public void addSale() {
        this.quantitySold++;
    }
    
    public String getName() { return name; }
    public int getQuantitySold() { return quantitySold; }
    public double getPrice() { return price; }
    public double getTotalRevenue() { return quantitySold * price; }
    
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Product)) return false;
        Product product = (Product) o;
        return product.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %d шт. * %.2f руб. = %.2f руб.", 
                           name, quantitySold, price, getTotalRevenue());
    }
}
