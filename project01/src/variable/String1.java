package variable;

public class String1 {
    public static void main(String[] args) {
    String str1 = "abc";
    String str2 = "def";

    boolean result1 = "abc".equals("abc");
    boolean result2 = "abc".equals("def");
    boolean result3 = str1.equals("abc");
    boolean result4 = str2.equals("def");

    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
    }
}
