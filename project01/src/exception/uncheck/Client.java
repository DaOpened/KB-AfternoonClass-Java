package exception.uncheck;


public class Client {
    public void callUncheckException() {
        throw new MyUncheckException("Client.call애서 에러 발생");
    }
}
