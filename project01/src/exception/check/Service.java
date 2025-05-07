package exception.check;

import java.util.Random;

public class Service {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.callCheckException();
        } catch (MyCheckException e) {
            e.printStackTrace();
        }
        System.out.println("막기 성공");

        try {
            client.CallRandException();
        } catch (MyCheckException2 e) {
            e.printStackTrace();
        }
    }
}
