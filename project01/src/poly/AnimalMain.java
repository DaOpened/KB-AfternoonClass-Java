package poly;

public class AnimalMain {
    public static void main(String[] args) {
        Donkey donkey = new Donkey();
        Dog dog = new Dog();
        Chicken chicken = new Chicken();
        Cat cat = new Cat();

//        donkey.sound();
//        dog.sound();
//        chicken.sound();
//        cat.sound();
        soundAnimal(donkey);
        soundAnimal(dog);
        soundAnimal(chicken);
        soundAnimal(cat);
    }

    static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
