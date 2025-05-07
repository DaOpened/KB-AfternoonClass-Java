package generic.method;

public class GenericMethodMain {
    public static void main(String[] args) {
        Integer value = GenericMethod.<Integer>genericMethod(12);
        Integer value2 = GenericMethod.genericMethod(12);
        System.out.println(value);

    }
}
