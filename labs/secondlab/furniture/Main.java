package furniture;

public class Main {
    public static void main(String[] args){
        Chair justChair = new Chair();
        HomeChair homeChair = new HomeChair("Ikea kitchen", "дерево", 2000, false, 4, false);
        OfficeChair officeChair = new OfficeChair("Компьютерное кресло", "кожа", 6000, true, 1, true, 60);
        Table justTable = new Table();
        HomeTable homeTable = new HomeTable("Ikea kitchen", "дерево", 12000, "прямоугольный", 4, true, 8, 4);
        OfficeTable officeTable = new OfficeTable("Компьютерный стол", "дерево", 8000, "уголок", 3);
        Bed justBed = new Bed();
        BedBed regularBed = new BedBed("Детская кровать", "дерево", 8000, 1.1, 1.7, 1);
        SofaBed sofaBed = new SofaBed("Тахта", "ткань", 10000, 0.8, 2.0, 2, true, 1.4);


        Furniture[] allFurniture = {justChair, homeChair, officeChair, justTable, homeTable, officeTable, justBed, regularBed, sofaBed};

        System.out.println("Всего объектов мебели: " + Furniture.getCount());
        
        for (Furniture furniture : allFurniture) {
            furniture.info();
            furniture.use();
            furniture.move();
        }

        homeTable.knock();
        officeTable.knock();

        System.out.println("Офисных стульев: " + officeChair.inventory());
        System.out.println("Офисных столов: " + officeTable.inventory());

        regularBed.use("'Гарри Поттер'");
        sofaBed.use("'Властелин колец'");

        System.out.println("Текущая ширина дивана: " + sofaBed.getWidth() + " м");
        sofaBed.fold();
        System.out.println("После раскладывания: " + sofaBed.getWidth() + " м");
        System.out.println("Площадь после раскладывания: " + sofaBed.area() + " квадратных метров");
        sofaBed.unfold();
        System.out.println("После складывания: " + sofaBed.getWidth() + " м");
        System.out.println("Площадь после складывания: " + sofaBed.area() + " квадратных метров");

        System.out.println("Текущая высота стула: " + officeChair.getHeight() + " м");
        officeChair.changeHeight(-10);
        System.out.println("Отрегулированная высота стула: " + officeChair.getHeight() + " м");
        
        System.out.println("Цена стула из Икеи: " + homeChair.getPrice());
        homeChair.setPrice(2200);
        System.out.println("Новая цена после скидки: " + homeChair.getPrice());
    }
}
