package stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); 
        System.out.println(stack.peek()); 
        stack.push(4);
        System.out.println(stack.pop()); 
        
        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println(stringStack.pop()); // World
        System.out.println(stringStack.peek()); // Hello
        
        Stack<Double> doubleStack = new Stack<>(3);
        System.out.println("Пуст ли стэк: " + doubleStack.isEmpty());
        System.out.println("Полон ли стэк: " + doubleStack.isFull());
        System.out.println("Размер стэка: " + doubleStack.size());
        try {
            doubleStack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage()); 
        }
        
        Stack<Character> charStack = new Stack<>(2);
        charStack.push('A');
        System.out.println("Пуст ли стэк: " + charStack.isEmpty());
        System.out.println("Полон ли стэк: " + charStack.isFull());
        System.out.println("Размер стэка: " + charStack.size());
        charStack.push('B');
        System.out.println("Пуст ли стэк: " + charStack.isEmpty());
        System.out.println("Полон ли стэк: " + charStack.isFull());
        System.out.println("Размер стэка: " + charStack.size());
        try {
            charStack.push('C');
        } catch (StackOverflowError e) {
            System.out.println("Ошибка: " + e.getMessage()); // Stack is full
        }
    }
}