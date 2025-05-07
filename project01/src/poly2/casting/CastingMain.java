package poly2.casting;

public class CastingMain {
    public static void main(String[] args) {
        Child child = new Child();

        child.childMethod();
        child.parentMethod();
        System.out.println();

        Parent parent = new Child();
        parent.parentMethod();
        // parent.childMethod(); // 에러 발생
        System.out.println();

        Child poly = (Child) parent;
        poly.childMethod();

        ((Child) parent).childMethod();
    }
}
