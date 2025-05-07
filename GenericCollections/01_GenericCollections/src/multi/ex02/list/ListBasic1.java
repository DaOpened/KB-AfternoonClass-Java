package multi.ex02.list;

import java.util.*;
import java.util.function.Consumer;

public class ListBasic1 {
    // https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html

    // 컬렉션(Collection)이란?
    // - 컬렉션 자바에서 기본적으로 제공하는 자료구조와 알고리즘을 담당하는 library
    // - 사용자가 별도의 알고리즘을 구현하지 않고, 미리 구현된 구조를 재사용하여 활용
    // - 편리성도 좋지만, 내부적으로 알고리즘 효율도 좋음으로 웬만하면 컬렉션을 활용하는 것이 표준

    //  ArrayList - ★★★★★ 추천
    //   -> 필드에서는 주로 ArrayList '만' 사용하는데, (심지어 type으로 통일!!)
    //      이유는 DB에서 데이터를 담고 탐색 용도로 많이 활용하기 때문이다.
    //  - 장점 : 탐색속도가 빠르고, 메모리를 적게 차지한다.
    //  - 단점 : 삽입, 삭제, 수정이 느리다.

    //  LinkedList -> 일반적으로 활용하지 않고 stack, queue, deque으로 활용한다.
    //   -> 삽입 삭제가 빈번하지 않으면 사용하지 않음. -> 이럴 경우가 많이 없거나 다른 컬렉션(Map)을 사용함
    //  - 장점 : 삽입, 삭제, 수정이 빠르다.
    //  - 단점 : 탐색속도가 느리고, 메모리를 많이 차지한다. << 단순 list의 최악의 효율

    //  Vector
    //  -> Thread safe 할때 사용하나 일반적으로 그냥 list를 동기화시 활용할리 없다. 그냥 알아만 두자.

    public static void main(String[] args) {
        // 객체 배열 문법
        Member[] memberArray = new Member[3];
        memberArray[0] = new Member("testID1", "김길동", 23, 60000.212);
        memberArray[1] = new Member("testID2", "홍길동", 32, 53123.233);
        memberArray[2] = new Member("testID3", "박길동", 25, 41212.322);
//     memberArray[3] = new Member("testID4", "박길동", 25, 41212.322); // 에러 발생

        // 배열의 단점
        // 1. 배열의 크기를 지정해야하고, 크기보다 커지면 새로운 배열을 생성하고 복사 필요
        // 2. 중간에 데이터 삽입/삭제가 어렵다. -> 반드시 빈데이터를 메꿔야한다!
        // 3. 복사도 어렵고, 사용자 실수가 많았다.
        // 결론 : 프로그래머라면 누구든 고통 받았다.


        // List 사용법
        // 1. 초기화 문법
        // - 정석적인 사용법은 List<E>로 type을 선언하는 것이지만, ArrayList<E>로 사용하는 사람도 많다.
        List<String> strList = new ArrayList<String>(); // 1.5버전 문법, type 생략 안한 버전
        List<Integer> intList = new ArrayList<>(); // 숫자 List, 정석적인 버전, 생략
        ArrayList<Member> memberList = new ArrayList<>(); // 컬렉션의 고유 이름을 생략하지 않은 버전
        LinkedList<Member> memberList2 = new LinkedList<>(); // LinkedList는 LinkedList 선언하는 것이 유리
        Queue<Member> queue = new LinkedList<>(); // 큐 LinkedList 로

        // 권장 패턴
        List<Member> list = new ArrayList<>();

        // 2. 인자를 넣고 생성하는 방법 or 배열에서 List로 전환하는 방법
        // 1) Arrays.asList() 활용
        List<String> strList2 = Arrays.asList("abc", "def", "ghi"); // immutahble - 추가 생성 삭제 불가!
        List<String> strList3 = List.of("abc", "def", "ghi");
        // strList2.add("test"); // 불가함

        // 수정 가능한 컬렉션으로 선언하는 방법 (mutable로 바꾸는 방법) ★★★
        List<String> strList4 = new ArrayList<>(List.of("abc", "def", "ghi")); // mutable - 추가 생성 삭제 가능!
        List<Member> mList1 = new ArrayList<>(Arrays.asList(memberArray)); // mutable - 추가 생성 삭제 가능!
        List<Member> mList2 = new ArrayList<>(List.of(memberArray)); // mutable - 추가 생성 삭제 가능!
        mList1.add(new Member("test7", "박길동", 30, 991211.2));

        System.out.println(mList1);
        System.out.println(mList2);

        // List 출력하는 방법(순회 하는 방법)
        // - List는 toString을 통해 객체 정보를 확인가능함
        System.out.println(mList2);
        System.out.println("---------------------------------------------------------------");
        System.out.println(mList2.toString().replace("},", "},\n"));
        System.out.println("---------------------------------------------------------------");

        // 순회하는 방법
        // 1. 기본적인 for 문
        for(Member m : mList2) {
            System.out.println(m.toString());
        }
        System.out.println("---------------------------------------------------------------");

        // 2. index 통해 접근하는 방법
        for(int i = 0; i < mList2.size(); i++) {
            System.out.println(mList2.get(i));
        }
        System.out.println("---------------------------------------------------------------");


        // 스트림 문법(Java8 이후)
        // 1) 익명 클래스로 Consumer를 생성하여 순회하는 방법 (권장X)
        mList2.forEach(new Consumer<Member>() {
            @Override
            public void accept(Member member) {
                System.out.println(member.toString());
            }
        });
        System.out.println("---------------------------------------------------------------");

        // 2) Consumer를 람다식으로 변환하여 출력하는 방법 (권장1)
        mList2.forEach( (Member m) -> {
            System.out.println((m));
        });
        System.out.println("---------------------------------------------------------------");

        // 3) Consumer + 메서드 참조
        mList2.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");

        // 4) 스트림 변환
        mList2.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
    }
}
