package com.my.ref;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest2 {
    public static void main(String[] args) {
        String[] names = {"Alice","Bob","Alice","Jane"};
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));

        System.out.println(uniqueNames);

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(7);
        numbers.add(6);
        numbers.add(4);
        System.out.println(numbers);

    }
}
