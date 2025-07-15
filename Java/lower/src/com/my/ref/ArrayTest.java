package com.my.ref;

public class ArrayTest {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        int [] arr2 = new int[]{11, 22, 33, 44, 55}; // 명시적  배열 생성
        int [] arr3 = null;                          // 동적으로 배열 생성
        arr3 = new int[]{1,34,4,4,4};
        int [] arr4 = new int[5];                    // 0으로 초기화 된 배열 생성

        int [][] arrays = {arr,arr2,arr3,arr4};
//
//        for (int i = 0; i <= 3; i++) {
//            for (int k = 0; k <= 3; k++) {
//                System.out.printf("%d",arrays[k][i]);
//            }
//        System.out.println(" ");
//        }
//
        String[] strArr = new String[3];
        strArr[0] = "Java";
        strArr[1] = "Java";
        strArr[2] = new String("Java");
//        System.out.println(strArr[0] == strArr[1]);
//        System.out.println(strArr[1] == strArr[2]);
//        System.out.println(strArr[1].equals(strArr[2]) );

//        for (int i = 0; i < strArr.length; i++) {
//            System.out.println(strArr[i]);
//        }

        for (String s: strArr){
            System.out.println(s);
        }
    }
}
