package product;

import java.util.HashSet;
import java.util.Set;

public class Store {
    private Set<Product> products;
    private double totalRevenue;
    
    public Store() {
        products = new HashSet<>();
        totalRevenue = 0.0;
    }
    public void addSale(String productName, double price) {
        Product existing = findProduct(productName);
        if (existing != null) {
            existing.addSale();
            existing.setPrice(price);
        } else {
            Product newProduct = new Product(productName, price);
            products.add(newProduct);
            System.out.println("Добавлен новый товар: " + productName);
        }
        
        totalRevenue += price;
    }
    private Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    public void SoldProducts() {
        if (products.isEmpty()) {
            System.out.println("Проданных товаров нет");
            return;
        }
        
        int counter = 1;
        for (Product product : products) {
            System.out.println(Integer.toString(counter) + ". " + product.toString());
            counter++;
        }
    }
    public double getTotalSales() {
        return totalRevenue;
    }
    public String getMostPopularProduct() {
        if (products.isEmpty()) {
            return "Нет данных о продажах";
        }
        
        Product mostPopular = null;
        int maxQuantity = 0;
        
        for (Product product : products) {
            if (product.getQuantitySold() > maxQuantity) {
                maxQuantity = product.getQuantitySold();
                mostPopular = product;
            }
        }
        
        return mostPopular.toString();
    }
}
