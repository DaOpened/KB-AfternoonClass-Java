package generic.ex02;

public class StrictGenericBox<Type> {
    private Type value;

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
       if(value instanceof String || value instanceof Integer || value instanceof Long) {
           this.value = value;
           System.out.println("전달 받은 값이 String / Integer / Long 이 맞습니다. 값을 저장 합니다.");
       }
       else {
           System.out.println("전달 받은 값이 String / Integer / Long 이 아닙니다.");
       }

    }
}
