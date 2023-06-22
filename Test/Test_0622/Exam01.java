package Test_0622;

class A{
    static int v1; //스태틱변수는 클래스 로딩될 때
    static void m1() {}
    static {
        System.out.println("A클래스의 스태틱 블록 실행");
    }
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
