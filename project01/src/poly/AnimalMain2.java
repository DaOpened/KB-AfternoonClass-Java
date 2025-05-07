package poly;

public class AnimalMain2 {
    public static void main(String[] args) {
        Animal[] animals = {new Donkey(), new Cat(), new Dog(), new Chicken()};

        for(Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
