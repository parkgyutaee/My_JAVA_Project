package com.my.generic;

class Util{
    public static <T>void printArray(T[] arr) {
        for (T item : arr){
            System.out.println(item);
        }
    }
}
public class GenericTest3 {
    public static void main(String[] args) {
        String[] names = {"Kim","Lee","Park"};
        Integer [] numbers = {1,2,3,4,5};
        Util.printArray(names);
        Util.printArray(numbers);
    }
}

/*
    와일드카드
    <?>
    <?  extends>
    <? Super T>
 */