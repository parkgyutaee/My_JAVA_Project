package com.my.obj;

class Counter {
   static int staticCount = 0 ;
   int count = 0;

   static {
       staticCount = 0;
   }

   Counter() {
       staticCount++;
       count++;
       System.out.printf("staticCount: %d, count: %d \n",staticCount,count);
   }

   public static int getStaticCount() {
       return staticCount;
   }
}

public class StaticClass {
    public static void main(String[] args) {

        Counter c = new Counter();
        Counter c2 = new Counter();

        Counter.staticCount = 10;                      //객체 생성 없이 클래스명으로 접근가능 --> 클래스 멤버

        System.out.println(Counter.getStaticCount());
        System.out.println(c.getStaticCount());        //객체를 통한 static 접근은 지양한다.
    }
}
