package exception.check;

import java.util.Random;

public class Client {
    public void callCheckException() throws MyCheckException {
        throw new MyCheckException("Client.call 에서 에러 발생");
    }

    public void CallRandException() throws MyCheckException2 {
        Random random = new Random();
        if(random.nextBoolean()) {
            throw new MyCheckException2("오늘은 운이 없으시군요");
        } else {
            System.out.println("오늘은 운이 좋으시군요");
        }
    }
}
