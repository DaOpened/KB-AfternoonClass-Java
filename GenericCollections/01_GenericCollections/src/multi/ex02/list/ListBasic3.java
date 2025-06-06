package multi.ex02.list;
import java.util.*;

public class ListBasic3 {
    public static void main(String[] args) {
        // 기본형 / 커스텀 정렬 방법 정리 ★★★★★
        // -> 코테 풀때 매우 중요함으로 아래 문법중 외울 문법을 정해서 반드시 외울것!!!! ★★★★★

        //  1. 컬렉션 기본형 정렬 (String, Integer, Double ...)
        // - Collections.sort or List.sort를 활용하여 정렬 가능
        // - 기본적으로 오름차순으로 정렬할수 있고, 내림차순 정렬시 몇가지 방법이 존재!
        //   -> 내림차순 필요시 Collections.reverse 활용
        System.out.println("1. 컬렉션 기본형 정렬 (String, Integer, Double ...)");
        List<Integer> intList = new ArrayList<>(List.of(4, 3, 2, 1, 5));
        Collections.sort(intList); // 가장 기본적인 정렬 ★★★★
        System.out.println(intList);

        // 오름차순 정렬
        intList.sort(Integer::compareTo);
        System.out.println(intList);

        intList.sort(Comparator.naturalOrder());
        System.out.println(intList);

        // 내립차순 정렬
        Collections.reverse(intList); // 가장 편리한 방법, 성능적으로 살짝 손해!
        System.out.println(intList);

        // 내림차순 정렬 다른 방법 (권장★)
        intList.sort(Comparator.reverseOrder());
        System.out.println(intList);
        System.out.println("-----------------------------------------------------------");

        // 문자열 정렬
        System.out.println("문자열 정렬");
        List<String> strList = new ArrayList<>(List.of("d", "b", "a", "c"));

        Collections.sort(strList);
        System.out.println(strList);

        strList.sort(Comparator.naturalOrder());
        System.out.println("오름차순: " + strList);

        // 내림차순
        strList.sort(Comparator.reverseOrder());
        System.out.println("내림차순: " + strList);
        System.out.println("-----------------------------------------------------------");

        // 2. 객체 커스텀 정렬 활용하기 ★★★★★
        // - 기본형이 아닌 경우 Comparator, Comparable을 통해 정렬할수 있다.
        // - Java8 이후 lambda 문법을 통해 간략화(?) 되었다.
        System.out.println("2. 객체 커스텀 정렬 활용하기 ★★★★★");
        List<Member> list = new ArrayList<>();
        list.add(new Member("TestID3", "홍길동3", 44, 11110.1));
        list.add(new Member("TestID4", "홍길동", 21, 143.1));
        list.add(new Member("TestID2", "홍길동2", 22, 100.1));
        list.add(new Member("TestID5", "최길동", 32, 4400.1));
        list.add(new Member("TestID6", "홍길동", 25, 10550.1));
        list.add(new Member("TestID7", "홍길순", 21, 10550.1));
        list.add(new Member("TestID8", "홍길동", 25, 20550.1));
        list.add(new Member("TestID1", "김길동", 25, 10550.1));

        System.out.println("\n정렬 이전!");
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 1) 객체에서 Comparable를 통해 정렬하는 방법 -> 추천 안함!!
        System.out.println("1) 객체에서 Comparable를 통해 정렬하는 방법 -> 추천 안함!!");
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2) Comparator를 통해 정렬하는 방법 ★★★★★
        // - 장점 : 다양한 기준으로 정렬 가능
        // - 단점 : 문법이 조금 복잡함
        System.out.println("2) Comparator를 통해 정렬하는 방법 ★★★★★");
        System.out.println("나이순으로 정렬하는 방법");
        list.sort(new Comparator<Member>(){
            @Override
            public int compare(Member o1, Member o2){
                // 커스텀 정렬 구현부
                // return (x < y)?-1:((x==y)?0:1);
                // return Integer.compare(o1.getAge(), o2.getAge()); // 오름차순
                return Integer.compare(o2.getAge(), o1.getAge());  // 내림차순
            };
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 3. 람다식 정렬(Java 8이상) ★★★★★
        // - 익명클래스나 함수를 람다식으로 바꿔 쉽게 표현 가능하다.
        // - 방법1 : Comparator 직접 구현 ex : (o1, o2) -> (returnValue) : 람다식 표현
        // - 방법2 : Comparator에서 getter로 정렬순서 정하기 가능
        // - 생소해서 문법 가독성이 살짝 떨어짐 -> 익숙해지면 편하다!
        System.out.println("3. 람다식 정렬(Java 8이상) ★★★★★");
        System.out.println("계좌 잔액순 정렬");

        // 방법1. Comparator를 람다식으로 직접 구현(코테용, 외울만 하다)
        list.sort((Member o1, Member o2) -> Double.compare(o2.getAccount(), o1.getAccount()));

        // 방법2. Comparator에서 선언된 객체의 getter 정렬
        list.sort(Comparator.comparing(Member::getAccount));
        list.forEach(System.out::println);
        System.out.println();
        list.sort(Comparator.comparing(Member::getAccount).reversed()); // 내림차순
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 4. Stream(=데이터 처리 용도, Java8 이상)을 통한 정렬
        // - 람다식중 하나인 Stream 문법을 통해 정렬하는 방법
        // - parallel를 활용하면 병렬처리 되어 매우 빠르게 정렬된다고 한다.
        System.out.println("나이순으로 정렬");
        List<Member> newList1 = list.stream()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList1.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // parallel 활용 문법
        List<Member> newList2 = list.stream().parallel()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList2.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 사용자 커스텀 정렬 활용하기 ★★★★★
        // - 이름 - 나이 - 계좌순 정렬

        // 1. 정렬을 3번 한다 --> 절대 비추!!
        System.out.println("이름 - 나이 - 계좌순 정렬1");
        list.sort(Comparator.comparingDouble(Member::getAccount));
        list.sort(Comparator.comparingInt(Member::getAge));
        list.sort(Comparator.comparing(Member::getName));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2. 익명 클래스(람다식) ★★★★★ 외울만하다
        System.out.println("이름 - 나이 - 계좌순 정렬2");
        list.sort((Member o1, Member o2) -> {
           int result = o1.getName().compareTo(o2.getName());
           if (result == 0) {
               result = Integer.compare(o2.getAge(), o1.getAge());
           }
           if (result == 0) {
               result = Double.compare(o2.getAccount(), o1.getAccount());

           }
           return result;
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 3. 스트림으로 한줄로 표현
        System.out.println("이름-나이-계좌순 정렬3");
        list.sort(Comparator.comparing(Member::getName).thenComparingInt(Member::getAge).thenComparingDouble(Member::getAccount));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
    }
}
