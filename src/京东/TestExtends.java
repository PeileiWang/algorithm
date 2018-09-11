package 京东;

/**
 * Created by WangPeilei
 * Time 2018/9/9 21:06
 */
public class TestExtends {
    public static void main(String[] args) {
        System.out.println(B.b);
    }
}

class A {

    public static String b = "B-";

    {
        System.out.println("A-initial");
    }

    static {
        System.out.println("A-static");
    }
}

class B extends A{


    static {
        System.out.println("B-static");
    }
}
