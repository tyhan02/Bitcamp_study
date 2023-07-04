package Project5;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");

        // 키보드 스캐너 준비
        Scanner scanner = new Scanner(System.in);

        final int MAX_SIZE = 100;
        int userId = 1;
        int length = 0;

        int[] no = new int[MAX_SIZE];
        String[] name = new String[MAX_SIZE];
        int[] price = new int[MAX_SIZE];
        String[] method = new String[MAX_SIZE];
        String[] category = new String[MAX_SIZE];

        // 물품 정보 등록
        for (int i = 0; i < MAX_SIZE; i++) {

            System.out.print("구매 물품? : ");
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
                        method[i] = "CASH";  // 따옴표로 감싸서 문자열로 저장
                        break loop;
                    case "2":
                        method[i] = "CARD";  // 따옴표로 감싸서 문자열로 저장
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
                        category[i] = "식사";
                        break loop;
                    case "2":
                        category[i] = "술";
                        break loop;
                    case "3":
                        category[i] = "쇼핑";
                        break loop;
                    case "4":
                        category[i] = "교통";
                        break loop;
                    case "5":
                        category[i] = "생활";
                        break loop;
                    case "6":
                        category[i] = "기타";
                        break loop;
                    default:
                        System.out.println("무효한 번호입니다.");
                }
            }

            no[i] = userId++;

            length++;

            System.out.print("계속 하시겠습니까?(Y/n) ");
            scanner.nextLine();
            String response = scanner.nextLine();
            if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println("---------------------------------------");

        System.out.println("번호, 물품, 가격, 품목, 카테고리");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %s, %s\n", no[i], name[i], price[i], method[i], category[i]);
        }
        scanner.close();
    }
}
