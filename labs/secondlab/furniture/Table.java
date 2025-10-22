package furniture;

public class Table extends Furniture{
    protected String shape;
    protected int numberOfLegs;

    public Table() {
        super();
    }

    public Table(String name, String material, double price, String shape, int numberOfLegs) {
        super(name, material, price);
        this.shape = shape;
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public void move() {
        System.out.println("кхххххх");
    }

    @Override
    public void use() {
        System.out.println("Это стол - за ним сидят");
    }

    public void knock() {
        System.out.println("тук-тук");
    }

    public String getShape() { 
        return shape; 
    }
    public void setShape(String shape) { 
        this.shape = shape; 
    }
    
    public int getNumberOfLegs() { 
        return numberOfLegs; 
    }
    public void setNumberOfLegs(int numberOfLegs) { 
        this.numberOfLegs = numberOfLegs; 
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Форма: " + shape + ", Кол-во ножек: " + numberOfLegs);
    }
}

class HomeTable extends Table implements FurnitureWithLegs{
    private boolean isExtendable;
    private int extendedGuests; // кол-во вмещаемых гостей в разложенном состоянии
    private int unextendedGuests; // кол-во вмещаемых гостей в неразложенном состоянии

    public HomeTable() {
        super();
    }

    public HomeTable(String name, String material, double price, 
                     String shape, int numberOfLegs, boolean isExtendable, int extendedGuests, int unextendedGuests) {
        super(name, material, price, shape, numberOfLegs);
        this.isExtendable = isExtendable;
        this.extendedGuests = extendedGuests;
        this.unextendedGuests = unextendedGuests;
    }

    @Override
    public void use() {
        System.out.println("Это стол - за ним едят");
    }

    public void extend() {
        if (isExtendable) {
            System.out.println("Теперь за столом помещаются " + extendedGuests  + " человек");
        } else {
            System.out.println("Этот стол не раскладывается, за столом по-прежнему помещаются" + unextendedGuests + " человек");
        }
    }

    public boolean isExtendable() { 
        return isExtendable; 
    }
    public int getExtendedGuests() { 
        return extendedGuests; 
    }
    public int getUnExtendedGuests() { 
        return unextendedGuests; 
    }
    public void setExtendedGuests(int newExtendedGuests) { 
        this.extendedGuests = newExtendedGuests; 
    }
    public void setUnExtendedGuests(int newUnExtendedGuests) { 
        this.unextendedGuests = newUnExtendedGuests;
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    @Override
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Раскладной: " + (isExtendable ? "да" : "нет"));
        if (isExtendable) {
            System.out.println("В разложенном состоянии вмещает: " + extendedGuests+ " человек");
        }
    }
}
class OfficeTable extends Table implements OfficeFurniture{
    private static int invCount = 0;

    public OfficeTable() {
        super();
        invCount ++;
    }

    public OfficeTable(String name, String material, double price, 
                       String shape, int numberOfLegs) {
        super(name, material, price, shape, numberOfLegs);
        invCount ++;
    }
    
    @Override
    public int inventory(){
        return invCount;
    }

    @Override
    public void use() {
        System.out.println("Это офисный стол - за ним по кнопочкам клацают");
    }

    @Override
    public void knock() {
        System.out.println("бам-бам"); 
    }
}

