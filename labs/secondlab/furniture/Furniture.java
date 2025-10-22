package furniture;

public abstract class Furniture {
    protected String name;
    protected String material;
    protected double price;
    private static int count = 0;

    public Furniture() { //конструктор по умолчанию
        count++; //счетчик созданных объектов (учет товаров в мебельном магазине)
     
    }

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
        count++; //счетчик созданных объектов (учет товаров в мебельном магазине)
    }

    public abstract void move(); // звук перетаскивания
    public abstract void use();  // как используется

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getMaterial() { 
        return material; 
    }

    public void setMaterial(String material) { 
        this.material = material; 
    }
    
    public double getPrice() { 
        return price; 
    }

    public void setPrice(double price) { 
        this.price = price; 
    }

    public static int getCount() { 
        return count; 
    }

    public void info() {
        System.out.println("Название: " + name + ", Материал: " + material + ", Цена: " + price);
    }
}
