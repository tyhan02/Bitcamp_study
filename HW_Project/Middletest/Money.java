package Middletest;


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

        System.out.print("총 용돈을 입력하세요: ");
        int totalAllowance = Integer.parseInt(scanner.next());
        int remainingAllowance = totalAllowance;

        // 물품 정보 등록
        for (int i = 0; i < MAX_SIZE; i++) {

            System.out.println("---------- 메뉴 ----------");
            System.out.println("1. 내역 등록");
            System.out.println("2. 목록 조회");
            System.out.println("3. 내역 분석");
            System.out.print("메뉴를 선택하세요: ");
            String menu = scanner.next();

            switch (menu) {
                case "1":
                    System.out.print("구매 물품? : ");
                    name[i] = scanner.next();

                    System.out.print("가격? ");
                    int expense = Integer.parseInt(scanner.next());
                    if (remainingAllowance - expense < 0) {
                        System.out.println("용돈이 부족합니다!");
                        break;
                    }
                    remainingAllowance -= expense;
                    price[i] = expense;

                    loop: while (true) {
                        System.out.println("결재수단 : ");
                        System.out.println("  1. 현금");
                        System.out.println("  2. 카드");
                        System.out.print("> ");
                        String paymentMethod = scanner.next();

                        switch (paymentMethod) {
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
                        String categoryOption = scanner.next();

                        switch (categoryOption) {
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
                    break;
                case "2":
                    System.out.println("---------------------------------------");
                    System.out.println("번호, 물품, 가격, 품목, 카테고리");
                    System.out.println("---------------------------------------");

                    for (int j = 0; j < length; j++) {
                        System.out.printf("%d, %s, %d, %s, %s\n", no[j], name[j], price[j], method[j], category[j]);
                    }
                    break;
                case "3":
                    int cashTotal = 0;
                    int cardTotal = 0;
                    int[] categoryTotal = new int[6];  // 카테고리별 총 금액

                    for (int j = 0; j < length; j++) {
                        if (method[j].equals("CASH")) {
                            cashTotal += price[j];
                        } else if (method[j].equals("CARD")) {
                            cardTotal += price[j];
                        }

                        switch (category[j]) {
                            case "식사":
                                categoryTotal[0] += price[j];
                                break;
                            case "술":
                                categoryTotal[1] += price[j];
                                break;
                            case "쇼핑":
                                categoryTotal[2] += price[j];
                                break;
                            case "교통":
                                categoryTotal[3] += price[j];
                                break;
                            case "생활":
                                categoryTotal[4] += price[j];
                                break;
                            case "기타":
                                categoryTotal[5] += price[j];
                                break;
                        }
                    }

                    int totalSpent = cashTotal + cardTotal;
                    int remainingAmount = totalAllowance - totalSpent;

                    System.out.println("---------------------------------------");
                    System.out.println("결제수단별 금액 비율");
                    System.out.println("현금 사용 금액: " + cashTotal + "원 (" + (cashTotal * 100 / totalSpent) + "%)");
                    System.out.println("카드 사용 금액: " + cardTotal + "원 (" + (cardTotal * 100 / totalSpent) + "%)");

                    System.out.println("---------------------------------------");
                    System.out.println("카테고리별 금액 비율");
                    System.out.println("식사: " + categoryTotal[0] + "원 (" + (categoryTotal[0] * 100 / totalSpent) + "%)");
                    System.out.println("술: " + categoryTotal[1] + "원 (" + (categoryTotal[1] * 100 / totalSpent) + "%)");
                    System.out.println("쇼핑: " + categoryTotal[2] + "원 (" + (categoryTotal[2] * 100 / totalSpent) + "%)");
                    System.out.println("교통: " + categoryTotal[3] + "원 (" + (categoryTotal[3] * 100 / totalSpent) + "%)");
                    System.out.println("생활: " + categoryTotal[4] + "원 (" + (categoryTotal[4] * 100 / totalSpent) + "%)");
                    System.out.println("기타: " + categoryTotal[5] + "원 (" + (categoryTotal[5] * 100 / totalSpent) + "%)");

                    System.out.println("---------------------------------------");
                    System.out.println("남은 용돈: " + remainingAmount + "원");
                    break;
                default:
                    System.out.println("무효한 번호입니다.");
            }

            System.out.println("----------------------------------");
            System.out.print("계속 하시겠습니까?(Y/n) ");
            scanner.nextLine();
            String response = scanner.nextLine();
            if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        scanner.close();
    }
}
//추가해야할거 json으로 저번달 내역과 비교
// 리팩토링 class 분리
// 각 달 내역 넣어놓기
// 사용 날짜 넣고 비교
// 월별 일별 비교 하기
// 메모기능
//