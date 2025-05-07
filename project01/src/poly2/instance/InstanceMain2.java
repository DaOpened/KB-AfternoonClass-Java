package poly2.instance;

public class InstanceMain2 {
    public static void main(String[] args) {
        Parent[] family = {new Parent(), new Child(), new GrandChild()};

        for (Parent p : family) {
            testInstanceOf(p);
        }
    }

    static void testInstanceOf(Parent p) {
        p.parentMethod();
         if (p instanceof GrandChild) {
            System.out.println("p는 GrandChild의 instance");
            ((GrandChild) p).GrandChildMethod();
        }
        else if (p instanceof Child) {
            System.out.println("p는 Child의 instance");
            ((Child) p).childMethod();
        }

        System.out.println();
    }
}
