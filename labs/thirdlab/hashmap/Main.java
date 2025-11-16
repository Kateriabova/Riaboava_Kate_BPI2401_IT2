package hashmap;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap orderManager = new HashMap();
        
        List<String> products1 = Arrays.asList("Ноутбук ASUS", "Мышь беспроводная", "Чехол для ноутбука");
        List<String> products2 = Arrays.asList("Смартфон Samsung", "Защитное стекло", "Чехол");
        List<String> products3 = Arrays.asList("Наушники JBL", "Коврик для мыши");
        
        Order order1 = new Order(products1);
        Order order2 = new Order(products2);
        Order order3 = new Order(products3);
        
        orderManager.put(1001, order1);
        orderManager.put(1002, order2);
        orderManager.put(1003, order3);
        
        System.out.println("Добавлено заказов: " + orderManager.size());
        
        Order foundOrder = orderManager.get(1001);
        if (foundOrder != null) {
            System.out.println("Заказ 1001 найден: " + foundOrder.getStatus());
        } else {
            System.out.println("Заказ 1001 не найден");
        }

        System.out.println("Дата заказа: " + orderManager.getOrderDate(1002));
        System.out.println("Статус: " + orderManager.getStatus(1002));
        System.out.println("Товары: " + orderManager.getProducts(1002));
        
        orderManager.confirm(1001);
        System.out.println("Статус заказа 1001: " + orderManager.getStatus(1001));
        System.out.println("Дата заказа 1001: " + orderManager.getOrderDate(1001));
        
        orderManager.send(1002);
        System.out.println("Статус заказа 1002: " + orderManager.getStatus(1002));
        
        orderManager.deliver(1003);
        System.out.println("Статус заказа 1003: " + orderManager.getStatus(1003));
    
        System.out.println("Поиск заказа 9999: " + orderManager.get(9999));
        orderManager.confirm(9999);
        System.out.println("Статус заказа 9999: " + orderManager.getStatus(9999));
  
        System.out.println("Заказов до удаления: " + orderManager.size());
        orderManager.remove(1002);
        System.out.println("Заказов после удаления: " + orderManager.size());
        System.out.println("Поиск удаленного заказа 1002: " + orderManager.get(1002));
        
        List<String> newProducts = Arrays.asList("Ноутбук ASUS", "Мышь беспроводная", "Сумка для ноутбука", "Охлаждающая подставка");
        Order updatedOrder = new Order(newProducts);
        updatedOrder.confirm();
        
        orderManager.put(1001, updatedOrder);
        System.out.println("Обновленные товары заказа 1001: " + orderManager.getProducts(1001));
        System.out.println("Статус заказа 1001: " + orderManager.getStatus(1001));
        
        System.out.println("Всего заказов: " + orderManager.size());
    }
}
