package com.my.ref;

import java.util.List;

import static javax.swing.UIManager.get;

public class LinkedList {
    public static void main(String[] args) {
        List<Number> linkedList = new java.util.LinkedList<>();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(40);

        System.out.println(linkedList);
        linkedList.add(2,30);
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
    }
}
