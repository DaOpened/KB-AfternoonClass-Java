package generic.ex02;

public class BoxMain {
    public static void main(String[] args) {
        StrictGenericBox<String> strictGenericBox1 = new StrictGenericBox<>();
        strictGenericBox1.setValue("hi");
        System.out.println(strictGenericBox1.getValue());

        StrictGenericBox<Integer> strictGenericBox2 = new StrictGenericBox<>();
        strictGenericBox2.setValue(12);
        System.out.println(strictGenericBox2.getValue());

        StrictGenericBox<Double> strictGenericBox3 = new StrictGenericBox<>();
        strictGenericBox3.setValue(3.0);
    }
}
