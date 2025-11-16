package hashmap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate orderDate;    
    private List<String> products;  
    private String status; 
    
    public Order(List<String> products){
        this.orderDate = LocalDate.now();
        this.products = new ArrayList<>(products);
        this.status = "В обработке";
    }

    LocalDate getOrderDate() {
        return orderDate;
    }
    
    List<String> getProducts() {
        return new ArrayList<>(products);
    }
    
    String getStatus() {
        return status;
    }

    void setStatus(String status){
        this.status = status;
    }

    void confirm(){
        setStatus("Подтвержден");
    }

    void send(){
        setStatus("Отправлен");
    }

    void deliver(){
        setStatus("Доставлен");
    }

    void cancel(){
        setStatus("Отменен");
    }
}
