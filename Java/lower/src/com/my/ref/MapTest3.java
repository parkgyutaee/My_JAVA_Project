package com.my.ref;

import java.util.Map;
import java.util.TreeMap;

public class MapTest3 {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("b", "banana");
        treeMap.put("a", "apple");
        treeMap.put("c", "cherry");
        System.out.println(treeMap);

    }
}
