package exception.basic.ex1;

public class Ex1Main {
    static class Parent {};
    static class Child extends Parent {
        void childMethod() {
            System.out.println("Child Method");

        }
    };

    public static void main(String[] args) {
        try {
            Parent parent = new Parent();
            Child poly = (Child) parent;
            poly.childMethod();
        } catch (Exception e) {
            System.out.println("예외 처리 완료!");
            e.printStackTrace();
        }
    }
}
