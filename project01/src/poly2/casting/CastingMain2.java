package poly2.casting;

public class CastingMain2 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = child;
        Parent parent2 = (Parent) child;

    }
}
