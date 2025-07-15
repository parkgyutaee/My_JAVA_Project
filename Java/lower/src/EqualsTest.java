public class EqualsTest {
    public static void main(String[] args){
        test1();
        System.out.println("");

        test2();

        System.out.println("");
        test3();
    }
    static void test1() {
        Object obj = new Object();
        Object obj2 = obj ;

        System.out.println(System.identityHashCode(obj));
        System.out.println(System.identityHashCode(obj2));

        boolean result = obj.equals(obj2);
        System.out.println(result);
    }
    static void test2() {
        String str = "홍길동";
        String str2 = "홍길동";

        boolean result2 = str.equals(str2);
        System.out.println(result2);
    }

    static void test3() {
        String str = new String("홍길동");
        String str2 = new String("홍길동");

        boolean result = str.equals(str2);
        System.out.println(result);
        System.out.println(str == str2);
        System.out.println(System.identityHashCode(str));
        System.out.println(System.identityHashCode(str2));

    }
}

// 하나이상의 스칼라