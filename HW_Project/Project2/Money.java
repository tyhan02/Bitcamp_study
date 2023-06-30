package Project2;

import java.time.Period;

public class Money {
    public static void main(String[] args) {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");


        int no= 1;
        String name = "삼각김밥";
        int price = 30000;
        char method = 'Q';
        char category  = 'A';



        System.out.printf("번호: %d\n", no);
        System.out.printf("물품: %s\n", name);
        System.out.printf("가격: %d\n", price);
        System.out.printf("거래 수단 (카드(P), 현금(Q)): %c\n", method);
        System.out.printf("카테고리(식사(A), 술(B), 쇼핑(C), 교통비(D), 생활(E), 기타(F)): %c\n", category);



    }
}