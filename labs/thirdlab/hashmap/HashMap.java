package hashmap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap {
    private class Entry {
        private int key;
        private Order value;

        public Entry(int key, Order value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() { return key; }
        public Order getValue() { return value; }
        public void setValue(Order value) { this.value = value; }
    }
    private LinkedList<Entry>[] table;  
    private int size = 0;
    final private int tableSize = 10000;

    public HashMap() {
        table = new LinkedList[tableSize];
    }

    public int hash(int key){
        return ((key + 13) * 47 / (31 + key % 100)) % tableSize;
    }

    public void put(int key, Order value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry> ();
        }

        for (Entry entry : table[index]) {
            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry(key, value));
        size ++;
    }

    public void remove(int key){
        int index = hash(key);
        if (table[index] == null) {
            return;
        }

        for (Entry entry : table[index]) {
            if (entry.getKey() == key) {
                table[index].remove(entry);
                size --;
                return;
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Order get(int key){
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry entry : table[index]) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return null;
    }

     public LocalDate getOrderDate(int key) {
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return null;
        }
        return order.getOrderDate();
    }
    
    public List<String> getProducts(int key) {
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return null;
        }
        return order.getProducts();
    }
    
    public String getStatus(int key) {
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return null;
        }
        return order.getStatus();
    }

    public void setStatus(int key, String status){
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return;
        }
        order.setStatus(status);
    }

    public void confirm(int key){
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return;
        }
        order.confirm();
    }

    public void send(int key){
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return;
        }
        order.send();
    }

    public void deliver(int key){
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return;
        }
        order.deliver();
    }

    public void cancel(int key){
        Order order = get(key);
        if (order == null) {
            System.out.println("Error, order wasn`t found");
            return;
        }
        order.cancel();
    }
}


