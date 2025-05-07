package scanner;

import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1번 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("2번 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        int sum = num1+num2;
        System.out.println("두 수의 합은: "+sum);
    }
}
