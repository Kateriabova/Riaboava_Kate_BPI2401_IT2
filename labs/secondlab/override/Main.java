package override;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.makeSound(); // Мяу!
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

