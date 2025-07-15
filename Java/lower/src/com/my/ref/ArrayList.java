package com.my.ref;

import java.util.List;

public class ArrayList {
    public static void main(String[] args) {

            List<String> arrayList = new java.util.ArrayList<>();
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("D");
            System.out.println(arrayList);

            arrayList.add(2,"c");
            System.out.println(arrayList);
    }
}
