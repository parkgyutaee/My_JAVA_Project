package com.my.obj;

// 접근제한자 private < default < protected < public
class Person {
    private String name;
    int defaultVal = 10 ;
    public String publicVal = "publicVal Access moidfier";




    // setter: 외부 접근을 막고 유효성 검사를 통해 필드값을 초기화한다.
    public void setName(String name) {
        this.name = name;
    }
    // getter 외부에서 객체필드를 읽어들일때 원하는 형태로 변경하여 리턴할 수 있다.
    public String getName() {
        return this.name;
    }

}





public class AccessMain {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Jane");

       System.out.println(p.getName());

    }
}
