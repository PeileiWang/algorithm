package 京东;

/**
 * Created by WangPeilei
 * Time 2018/9/9 21:06
 */
public class TestExtends {
    public static void main(String[] args) {
        new B();
    }
}

class A {

    {
        System.out.println("A-initial");
    }

    static {
        System.out.println("A-static");
    }
}

class B extends A{

    public static String b = "B-";

    static {
        System.out.println("B-static");
    }
}
