package Test_0621_1;

import Test_0621.A;

public class Test3 extends A {
    public static void main(String[] args) {
        A obj = new A();
        //obj.v1 =100; 접근불가!!!
        //obj.v2 =200; 접근불가!!!
        //obj.v3 =300; 접근불가!!! <== 상속받은 멤버가 아님

        obj.v4 =400;
        //obj.m(); 접근불가!!! <= 상속받은 멤버가 아님

        m2();
        Test3 obj2 = new Test3();
        obj2.m3();
        // obj2.v1 =100; 접근불가!!!
        // obj2.v2 =200; 접근불가!!!

        obj2.v3 =300; //상속받아서 만든 필드기 떄문에 자식 클래스가 접근 가능!

    }
    static void m2(){

    }
    void m3(){

    }
}
