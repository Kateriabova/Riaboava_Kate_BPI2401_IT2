package animals;

public class Animal {
    protected String name;
    public void eat() {
        System.out.println(name + " ест.");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println(name + " лает.");
    }
}

