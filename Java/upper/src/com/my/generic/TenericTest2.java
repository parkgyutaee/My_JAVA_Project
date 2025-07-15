package com.my.generic;

class Box<T>{
    private T value;

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    /*
        class Box<T>{
        private T value;

        public void setValue(T value){
            this.value = value;
        }
        public T getValue(){
            return value;
        }
        }
     */

}
public class TenericTest2 {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<String>();
        stringBox.setValue("Hello");
        System.out.println(stringBox.getValue());

        Box<Integer> integerBox = new Box<Integer>();

        integerBox.setValue(123);
        System.out.println(integerBox.getValue());

    }
}
