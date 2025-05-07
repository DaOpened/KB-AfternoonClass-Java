package poly3.abstracts;

public class Ex1Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.eat();
        dog.eat();

        ((Dog) dog).sound();
        ((Cat) cat).sound();
    }
}
