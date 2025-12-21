package product;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        
        store.addSale("Хлеб", 50.0); 
        store.addSale("Молоко", 80.0);   
        store.addSale("Хлеб", 50.0); 
        store.addSale("Хлеб", 50.0);  
        store.addSale("Яйца", 120.0);
        store.addSale("Шоколад", 60.0);
        store.addSale("Шоколад", 60.0);
        store.addSale("Шоколад", 60.0);
        store.addSale("Шоколад", 60.0);
        store.addSale("Хлеб", 50.0); 
        store.addSale("Молоко", 80.0); 
        store.addSale("Хлеб", 50.0); 
        store.addSale("Яйца", 80.0); 

        
        store.SoldProducts();
        System.out.println(store.getTotalSales());
        System.out.println(store.getMostPopularProduct());
    }
}
