package Project4;

import java.util.Scanner;
public class Money {
    public static void main(String[] args) {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");

        Scanner scanner = new Scanner(System.in);

        final int SIZE = 100;

        int[] no = new int[SIZE];
        String[] name = new String[SIZE];
        int[] price = new int[SIZE];
        char[] method = new char[SIZE];
        char[] category = new char[SIZE];

        for (int i = 0; i < SIZE; i++) {
            System.out.print("번호? ");
            no[i] = scanner.nextInt();

            System.out.print("물품? ");
            name[i] = scanner.next();

            System.out.print("가격? ");
            price[i] = scanner.nextInt();


            System.out.print("거래 수단 (카드(P), 현금(Q))?: ");
            String str1 = scanner.next();
            method[i] = str1.charAt(0);

            System.out.print("카테고리(식사(A), 술(B), 쇼핑(C), 교통비(D), 생활(E), 기타(F))?: ");
            String str2 = scanner.next();
            category[i] = str2.charAt(0);

        }

        System.out.println("---------------------------------------");

        for (int i = 0; i < SIZE; i++) {

            System.out.printf("번호: %d\n", no);
            System.out.printf("물품: %s\n", name);
            System.out.printf("가격: %d\n", price);
            System.out.printf("거래 수단 (카드(P), 현금(Q)): %c\n", method);
            System.out.printf("카테고리(식사(A), 술(B), 쇼핑(C), 교통비(D), 생활(E), 기타(F)): %c\n", category);

            scanner.close();
        }

    }
}