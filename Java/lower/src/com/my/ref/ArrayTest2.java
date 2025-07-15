package com.my.ref;

public class ArrayTest2 {
    public static void main(String[] args) {
        int [] nums = null;
        nums = new int[] {10,20,30,40};

        int sum = 0;     //누적하는 변수는 초기화
        for (int i : nums){
            sum += i;
        }
    System.out.println("총합: " + sum);

    int result = add(nums);
    System.out.println(result);
    }


    public static int add(int[] ary) {

        int result = 0;
        for (int n : ary){
            result += n + 1;
        }
        return result;


    }
}
