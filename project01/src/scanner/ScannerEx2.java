package scanner;

import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randNum = (int)(Math.random()*100);
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            int num = sc.nextInt();

            if(num == randNum) {
                System.out.println("정답입니다.");
                break;
            }
            else if (num > randNum) {
                System.out.println("DOWN");
            }
            else{
                System.out.println("UP");
            }
        }
    }
}
