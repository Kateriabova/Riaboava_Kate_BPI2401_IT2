package furniture;

public class Bed extends Furniture{
    protected double width;
    protected double length;
    protected int sleepingPlaces;

    public Bed() {
        super();
    }

    public Bed(String name, String material, double price, double width, double length, int sleepingPlaces) {
        super(name, material, price);
        this.width = width;
        this.length = length;
        this.sleepingPlaces = sleepingPlaces;
    }

    @Override
    public void move() {
        System.out.println("скрииииип");
    }

    @Override
    public void use() {
        System.out.println("Это кровать - на ней спят");
    }
 
    public double getWidth() { 
        return width; 
    }
    public void setWidth(double width) { 
        this.width = width; 
    }
    
    public double getLength() { 
        return length; 
    }
    public void setLength(double length) { 
        this.length = length; 
    }
    
    public int getSleepingPlaces() { 
        return sleepingPlaces; 
    }
    public void setSleepingPlaces(int sleepingPlaces) { 
        this.sleepingPlaces = sleepingPlaces; 
    }

    public double area() {
        return width * length;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Размер: " + width + "*" + length + "м, Спальных мест: " + sleepingPlaces);
    }
}

class SofaBed extends Bed {
    private boolean isFoldable; // может ли вообще раскладываться
    private double foldedWidth; // ширина в разложенном состоянии
    private double unfoldedWidth; // ширина в неразложенном состоянии

    public SofaBed() {
        super();
    }

    public SofaBed(String name, String material, double price, 
                   double unfoldenWidth, double length, int sleepingPlaces, boolean isFoldable, double foldedWidth) {
        super(name, material, price, unfoldenWidth, length, sleepingPlaces);
        this.isFoldable = isFoldable;
        this.unfoldedWidth = unfoldenWidth;
        if (! isFoldable){
            this.foldedWidth = unfoldenWidth; //для нераскладывющихся кроватей
        } else{
            this.foldedWidth = foldedWidth;
        }  
    }

    @Override
    public void use() {
        System.out.println("Это диван-кровать - на нем смотрят телевизор");
    }

    public void use(String name) {
        System.out.println("Это диван-кровать - на нем смотрят фильм " + name);
    }

    public void fold() {
        width = foldedWidth;
    }

    public void unfold() {
        width = unfoldedWidth;
    }

    public boolean isFoldable() {
        return isFoldable; 
    }

    public double getFoldedWidth() {
        return foldedWidth; 
    }

    public double getUnFoldedWidth() {
        return foldedWidth; 
    }

    public void setFoldedWidth(double newWidth) {
        this.foldedWidth = newWidth;
    }

     public void setUnfoldedWidth(double newWidth) {
        this.unfoldedWidth = newWidth;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Раскладной: " + (isFoldable ? "да" : "нет"));
    }
}
class BedBed extends Bed {
    public BedBed() {
        super();
    }

    public BedBed(String name, String material, double price, 
                   double width, double length, int sleepingPlaces) {
        super(name, material, price, width, length, sleepingPlaces);
    }

    @Override
    public void use() {
        System.out.println("Это кровать-кровать - на ней читают книжку");
    }

    public void use(String name) {
        System.out.println("Это кровать-кровать - на ней читают книжку " + name);
    }
}
