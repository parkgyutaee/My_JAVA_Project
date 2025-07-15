package com.my.ref;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        Map<String, String> linkedMap  = new LinkedHashMap<>();

        linkedMap.put("b","banana");
        linkedMap.put("a","apple");
        linkedMap.put("c","cherry");

        System.out.println(linkedMap);
    }
}
