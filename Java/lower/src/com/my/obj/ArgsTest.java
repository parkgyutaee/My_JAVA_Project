package com.my.obj;

class ArgsClass {


//    void paramf(int... values) {                //가변길이 매개변수
//        for (int i = 0; i < values.length; i++){
//            System.out.println(values[i]);
      void paramf(int [] values) {
          for (int i = 0; i < values.length; i++){
              System.out.println(values[i]);
          }
      }


}

public class ArgsTest {
    public static void main(String[] args) {
        ArgsClass obj = new ArgsClass();
        int i = 4, i2 = 5;
        int [] arr = {1,2,3,4,5,6,7};
        obj.paramf(arr);




    }
}
