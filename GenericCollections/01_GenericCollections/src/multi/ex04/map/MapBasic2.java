package multi.ex04.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapBasic2 {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("testID1", "김길동1", 21, 10000.123));
        list.add(new Member("testID1", "김길동1", 21, 10000.123)); // 완전동일
        list.add(new Member("testID3", "김길동3", 23, 444000.123));
        list.add(new Member("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
        list.add(new Member("testID2", "김길동2", 22, 10000.123));

        // 선언법
        Map<String, Member> map = new HashMap<>();

        // 1. 데이터 삽입하는 방법
        for(Member m : list){
            // 기본적인 문법 put
            map.put(m.getId(), m);

            // 덮어쓰지 않고 데이터 넣는 방법
            // get : 데이터를 가져오는 방법, 없으면 null
            if(map.get(m.getId()) == null){
                map.put(m.getId(), m);
            }

            // 덮어쓰지 않고 데이터 넣는 방법2
            // containKey : 키값이 있는지 확인하는 메서드
            if(!map.containsKey(m.getId())){
                map.put(m.getId(), m);
            }

            // 덮어쓰지 않고 데이터 넣는 방법3
            // putIfAbsent : 키값이 존재하지 않을때만 put하는 메서드
            map.putIfAbsent(m.getId(), m);
        }
        map.forEach((k, v)-> System.out.println("k : " + k + " v : " + v));

        // 2. 순회하는 방법
        // 1) keySet - 표준적인 방법 ★★★★★
        Set<String> keySet = map.keySet();
        for(String k : keySet){
            System.out.println(k + " : " + map.get(k));
        }

        // 2) entrySet - key-value 둘다 쌍으로 가져오는 방법
        Set<Map.Entry<String, Member>> entrySet = map.entrySet();
        for(Map.Entry<String, Member> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("------------------------------------------------");

        // 3) forEach
        map.forEach((k, v) -> System.out.println("k : " + k + " v : " + v));
        System.out.println("------------------------------------------------");


        // 3. 데이터를 가져오는 방법
        // get : key를 통해 value를 가져오거, key가 없으면 null을 반환
        System.out.println(map.get("testID1")); // value
        System.out.println(map.get("testID198391830912")); // null

        // getOrDefault : key값이 없는 경우 default값을 선언할수 있는 기능
        System.out.println(map.get("testID1").getId()); // key가 없으면 죽는 코드
//        System.out.println(map.get("testID198391830912").getId()); 죽는 코드!!
        System.out.println(map.getOrDefault("testID1", new Member()));

        // getOrDefault를 안쓰고 default값 만드는 코드 -> if문
        Member member = map.get("testID1");
        if(member == null){
            member = new Member();
        }
        System.out.println(member);


        // 4. 삭제하는 방법
//        map.remove("testID1"); // 기본적인 방법
        Member m2 = map.remove("testID1");
        System.out.println(m2);
        if(m2 == null){
            System.out.println("데이터가 없음");
        }else{
            System.out.println("데이터가 있어서 삭제 완료!!");
        }
        System.out.println("------------------------------------------------");

        // 5. 수정하는 방법
        // - 기본적으로 map은 덮어쓰기가 됨으로 put으로 충분하다.
        // - replace 메서드가 존재해서 put과 같이 사용할수도 있음
        map.put("testID2", new Member("testID2", "최길동", 22, 10000.123));
        System.out.println(map.get("testID2"));
        map.replace("testID2", new Member("testID2", "최길동", 22, 10000.123));
        System.out.println(map.get("testID2"));

        // value에 있는 개체 일부값만 변경하고 싶을때
        map.get("testID2").setName("홍길동"); // 안전한 방법이 아님!!

        // 안전한 방법
        Member m3 = map.get("testID2");
        if(m3 != null){ // null check 권장!
            m3.setAge(40);
        }
        System.out.println(map.get("testID2"));

        // 6. map의 사이즈, 비어있는지 조회
        System.out.println(map.size()); // size
        System.out.println(map.isEmpty()); // false

        // 7. map 비우는 방법
        map.clear(); // 초기화
        System.out.println(map);
        map = null; // GC로 인한 초기화 됨
        System.out.println(map);
    }
}
