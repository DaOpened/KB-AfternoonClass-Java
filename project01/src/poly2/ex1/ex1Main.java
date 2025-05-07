package poly2.ex1;

public class ex1Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.eat();
        dog.eat();

        ((Dog) dog).sound();
        ((Cat) cat).sound();
    }
}
