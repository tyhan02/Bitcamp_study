package Test_0622;

class A{

    static int v1=111; //스태틱변수는 클래스 로딩될 때
    static {
        v1=100;
        System.out.println("A클래스의 스태틱 블록 실행");
    }
    static {
        v1=200;
        System.out.println("A클래스의 스태틱 블록 실행2");
    }
    static {
        v1=300;
        System.out.println("A클래스의 스태틱 블록 실행3");
    }
    static int v2=222;
    static void m1(){}
}
public class Exam01 {
    public static void main(String[] args) {
        A obj;

//        A.v1 = 100;
//        A.m1();
//        obj = new A();
        try {
            Class.forName("Test_0622.A");

        }catch (ClassNotFoundException e){
            System.out.println("클래스 못찾네");
        }
    }
}
