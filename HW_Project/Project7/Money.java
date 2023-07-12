package Project7;

import java.util.Scanner;

public class Money {

    static Scanner scanner = new Scanner(System.in);

    static final int MAX_SIZE = 100;
    static int userId = 1;
    static int length = 0;

    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static int[] price = new int[MAX_SIZE];
    static String[] method = new String[MAX_SIZE];
    static String[] category = new String[MAX_SIZE];

    public static void main(String[] args) {

        printTitle();

        while (length < MAX_SIZE) {
            inputMember();
            if (!promptContinue()) {
                break;
            }
        }

        printMembers();

        scanner.close();
    }


    static void printTitle() {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");
    }

    static void inputMember() {

        name[length] = prompt("품목?: ");
        price[length] = Integer.parseInt(prompt("가격?: "));

        loop:
        while (true) {
            System.out.println("결재수단 : ");
            System.out.println("  1. 현금");
            System.out.println("  2. 카드");
            System.out.print("> ");
            String menu1 = scanner.next();

            switch (menu1) {
                case "1":
                    method[length] = "CASH";  // 따옴표로 감싸서 문자열로 저장
                    break loop;
                case "2":
                    method[length] = "CARD";  // 따옴표로 감싸서 문자열로 저장
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        loop:
        while (true) {
            System.out.println("카테고리: ");
            System.out.println("  1. 식사");
            System.out.println("  2. 술");
            System.out.println("  3. 쇼핑");
            System.out.println("  4. 교통");
            System.out.println("  5. 생활");
            System.out.println("  6. 기타");
            System.out.print("> ");
            String menu2 = scanner.next();

            switch (menu2) {
                case "1":
                    category[length] = "식사";
                    break loop;
                case "2":
                    category[length] = "술";
                    break loop;
                case "3":
                    category[length] = "쇼핑";
                    break loop;
                case "4":
                    category[length] = "교통";
                    break loop;
                case "5":
                    category[length] = "생활";
                    break loop;
                case "6":
                    category[length] = "기타";
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        no[length] = userId++;
        length++;
    }

    static boolean promptContinue() {

        String response = prompt("계속 하시겠습니까?(Y/n)");
        if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }

    static void printMembers() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 가격, 품목, 카테고리");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %s, %s\n", no[i], name[i], price[i], method[i], category[i]);
        }
    }

    static String prompt(String title) {
        System.out.print(title);
        return scanner.nextLine();
    }
}
