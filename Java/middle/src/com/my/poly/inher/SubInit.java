package com.my.poly.inher;

/*
    상속된 자식 객체를 생성하면 부모의 생성자도 호출된다.(super())
    여기서 말하는 생성자는 디폴트 생성자다.
 */
public class SubInit extends SuperInit {
    String code;

    public SubInit(String country, String city, String code){
        super(); // 부모 생성자 호출코드 , 생략 가능하다.
        this.country = country;
        this.city = city;
        this.code = code;

        System.out.println("SuperClass Constructor");
    }

}
