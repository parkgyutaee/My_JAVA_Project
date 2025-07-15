package com.my.ref;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new HashMap<>();

        ageMap.put("Alice", 30);  // put은 추가 , remove는 삭제 , null key 허용
        ageMap.put("Bob", 20);
        ageMap.put("Jane", 20);
//        System.out.println(ageMap);
//        System.out.println(ageMap.get(20));
//
//        ageMap.remove("Jane");
//        System.out.println(ageMap);
//        System.out.println(ageMap.containsKey("Jane"));
//
//        ageMap.put(null,0);
//        System.out.println(ageMap);
//
//
        ageMap.put("Jane",25);
        System.out.println(ageMap);
    }
}
