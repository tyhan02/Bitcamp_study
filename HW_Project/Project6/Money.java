package Project6;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_SIZE = 100;
        int userId = 1;
        int length = 0;

        int[] no = new int[MAX_SIZE];
        String[] name = new String[MAX_SIZE];
        int[] price = new int[MAX_SIZE];
        char[] method = new char[MAX_SIZE];
        char[] category = new char[MAX_SIZE];

        printTitle();

        for (int i = 0; i < MAX_SIZE; i++) {
            inputMember(scanner, i, name, price, method,category, no, userId++);
            length++;
            if (!promptContinue(scanner)) {
                break;
            }
        }

        printMembers(length, no, name, price, method,category);

        scanner.close();
    }


    static void printTitle() {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");
    }

    static void inputMember(Scanner scanner, int i,
                            String[] name, int[] price, char[] method, char[] category, int[] no, int userId) {

        System.out.print("이름? ");
        name[i] = scanner.next();

        System.out.print("가격? ");
        price[i] = Integer.parseInt(scanner.next());

        loop: while (true) {
            System.out.println("결재수단 : ");
            System.out.println("  1. 현금");
            System.out.println("  2. 카드");
            System.out.print("> ");
            String menu1 = scanner.next();

            switch (menu1) {
                case "1":
                    method[i] = 'P';
                    break loop;
                case "2":
                    method[i] = 'Q';
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        loop: while (true) {
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
                    category[i] = 'A';
                    break loop;
                case "2":
                    category[i] = 'B';
                case "3":
                    category[i] = 'C';
                case "4":
                    category[i] = 'D';
                case "5":
                    category[i] = 'E';
                case "6":
                    category[i] = 'F';

                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        no[i] = userId++;

        }
    static boolean promptContinue(Scanner scanner) {
        System.out.print("계속 하시겠습니까?(Y/n) ");
        String response = scanner.nextLine();
        if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }


    static void printMembers(int length, int[] no, String[] name, int[] price, char[] method, char[] category) {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 가격, 품목, 카테고리");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %c, %c\n", no[i], name[i], price[i], method[i],category[i]);
        }
    }
}
