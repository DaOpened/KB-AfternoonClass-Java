package generic.ex01;

public class GenericBoxMain {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setValue(12);
        System.out.println(integerBox.getValue());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setValue("Hello World");
        System.out.println(stringBox.getValue());
    }
}
