package furniture;

public class Chair extends Furniture implements FurnitureWithLegs{
    protected boolean hasSoftSeat;
    protected int numberOfLegs;
    protected boolean hasArmrests;

    public Chair() {
        super();
    }

    public Chair(String name, String material, double price, 
                 boolean hasSoftSeat, int numberOfLegs, boolean hasArmrests) {
        super(name, material, price);
        this.hasSoftSeat = hasSoftSeat;
        this.numberOfLegs = numberOfLegs;
        this.hasArmrests = hasArmrests;
    }

    @Override
    public void move() {
        System.out.println("тшшшшш");
    }

    @Override
    public void use() {
        System.out.println("Это стул - на нем сидят");
    }

    public boolean hasSoftSeat() {
        return hasSoftSeat; 
    }
    public void setHasSoftSeat(boolean hasSoftSeat) {
        this.hasSoftSeat = hasSoftSeat;
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    
    @Override
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
    
    public boolean hasArmrests() {
        return hasArmrests;
    }

    public void setHasArmrests(boolean hasArmrests) { this.hasArmrests = hasArmrests; }

    @Override
    public void info() {
        super.info(); //выводим стандартные параметры
        System.out.println("Мягкое сиденье: " + (hasSoftSeat ? "да" : "нет") + ", Кол-во ножек: " + numberOfLegs + ", Подлокотники: " + (hasArmrests ? "есть" : "нет"));
        //используем тернарный оператор
    }
}

class OfficeChair extends Chair implements OfficeFurniture{
    private int height; //высота стула
    private static int invCount = 0;

    public OfficeChair() {
        super();
        this.height = 50; // стандартная высота
        invCount ++;
    }

    public OfficeChair(String name, String material, double price, 
                       boolean hasSoftSeat, int numberOfLegs, boolean hasArmrests, 
                       int height) {
        super(name, material, price, hasSoftSeat, numberOfLegs, hasArmrests);
        this.height = height;
        invCount ++;
    }

    @Override
    public void move() {
        System.out.println("вжжжжух");
    }

    @Override
    public void use() {
        System.out.println("Это офисный стул - на нем устраивают гонки по офису");
    }

    @Override
    public int inventory(){
        return invCount;
    }

    public void changeHeight(int increase) {
        this.height += increase;
    }

    public int getHeight() { 
        return height; 
    }

    public void setHeight(int newHeight) { 
        this.height = newHeight; 
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Текущая высота: " + height + "см");
    }
}

class HomeChair extends Chair {
    public HomeChair() {
        super();
    }

    public HomeChair(String name, String material, double price, 
                     boolean hasSoftSeat, int numberOfLegs, boolean hasArmrests) {
        super(name, material, price, hasSoftSeat, numberOfLegs, hasArmrests);
    }

    @Override
    public void use() {
        System.out.println("Это домашний стул - на него встают, чтобы поменять лампочки");
    }
}