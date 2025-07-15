package com.my.prj;


class MyClass {
    String name;
    int age;

    MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ToStringMain {
    public static void main(String[] args) {
        MyClass my = new MyClass("박규태",26);

        System.out.printf("name %s, age: %d \n",my.name,my.age);
        System.out.println(my);
    }
}
