package interfaces;

interface InterfaceA {
    void methodA();
}

interface InterfaceB {
    void methodB();
}

public class MyClass implements InterfaceA, InterfaceB {
    // Реализация методов из обоих интерфейсов
    @Override
    public void methodA() {
        System.out.println("Метод A");
    }

    @Override
    public void methodB() {
        System.out.println("Метод B");
    }
}
