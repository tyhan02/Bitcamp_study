package Project9;

import java.util.HashMap;
import java.util.Map;
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
    static String[] date = new String[MAX_SIZE];

    public static void main(String[] args) {

        printTitle();

        while (length < MAX_SIZE) {
            inputMember();
            if (!promptContinue()) {
                break;
            }
        }

        printMembers();

        // 추가한 기능 - 월별 소비 분포와 월별 지출 비율 메뉴 호출
        while (true) {
            printMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    calculateMonthlySpendingDistribution();
                    break;
                case 2:
                    calculateMonthlyExpenditureRatio();
                    break;
                case 3:
                    calculateMonthlyView();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택하세요.");
            }
        }
    }

    static void printTitle() {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");
    }

    static void inputMember() {
        date[length] = prompt("날짜 (YYYY-MM-DD)?: ");
        name[length] = prompt("품목?: ");
        price[length] = Integer.parseInt(prompt("가격?: "));

        // 결제 수단 입력
        loop:
        while (true) {
            System.out.println("결재수단 : ");
            System.out.println("  1. 현금");
            System.out.println("  2. 카드");
            System.out.print("> ");
            String menu1 = scanner.next();

            switch (menu1) {
                case "1":
                    method[length] = "CASH";
                    break loop;
                case "2":
                    method[length] = "CARD";
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        // 카테고리 입력
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
        return response.equalsIgnoreCase("Y");
    }

    static void printMembers() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 가격, 결재수단, 카테고리, 날짜");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %s, %s, %s\n", no[i], name[i], price[i], method[i], category[i], date[i]);
        }
    }

    static String prompt(String title) {
        System.out.print(title);
        return scanner.next();
    }

    // 추가한 기능 - 메뉴 출력
    static void printMenu() {
        System.out.println("\n=====================");
        System.out.println("1. 월별 소비 분포");
        System.out.println("2. 월별 지출 비율");
        System.out.println("3. 월별 조회");
        System.out.println("4. 종료");
        System.out.println("=====================");
        System.out.print("메뉴를 선택하세요: ");
    }

    // 추가한 기능 - 월별 소비 분포를 계산하여 출력
    static void calculateMonthlySpendingDistribution() {
        Map<String, Integer> monthlyDistributionCash = new HashMap<>();
        Map<String, Integer> monthlyDistributionCard = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String[] dateParts = date[i].split("-");
            String yearMonth = dateParts[0] + "-" + dateParts[1];
            int currentSpending = price[i];
            if (method[i].equalsIgnoreCase("CASH")) {
                int currentCashSpending = monthlyDistributionCash.getOrDefault(yearMonth, 0);
                monthlyDistributionCash.put(yearMonth, currentCashSpending + currentSpending);
            } else if (method[i].equalsIgnoreCase("CARD")) {
                int currentCardSpending = monthlyDistributionCard.getOrDefault(yearMonth, 0);
                monthlyDistributionCard.put(yearMonth, currentCardSpending + currentSpending);
            }
        }

        System.out.println("\n---------------------------------------");
        System.out.println("월별 소비 분포 (현금)");
        System.out.println("---------------------------------------");
        for (Map.Entry<String, Integer> entry : monthlyDistributionCash.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n---------------------------------------");
        System.out.println("월별 소비 분포 (카드)");
        System.out.println("---------------------------------------");
        for (Map.Entry<String, Integer> entry : monthlyDistributionCard.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    // 추가한 기능 - 월별 지출 비율을 계산하여 출력
    static void calculateMonthlyExpenditureRatio() {
        Map<String, Integer> categoryExpenses = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int currentExpense = price[i];
            if (currentExpense < 0) {
                String currentCategory = category[i];
                int currentCategoryExpense = categoryExpenses.getOrDefault(currentCategory, 0);
                categoryExpenses.put(currentCategory, currentCategoryExpense - currentExpense);
            }
        }

        int totalIncome = 0;
        int totalExpense = 0;

        for (int i = 0; i < length; i++) {
            if (price[i] > 0) {
                totalIncome += price[i];
            } else {
                totalExpense -= price[i];
            }
        }

        System.out.println("\n---------------------------------------");
        System.out.println("월별 지출 비율 (카테고리별)");
        System.out.println("---------------------------------------");
        for (Map.Entry<String, Integer> entry : categoryExpenses.entrySet()) {
            double categoryExpenditureRatio = (double) entry.getValue() / totalIncome * 100;
            System.out.printf("%s: %.2f%%\n", entry.getKey(), categoryExpenditureRatio);
        }

        System.out.println("\n------------------------------------");
        System.out.println("월별 지출 비율 (전체)");
        System.out.println("---------------------------------------");
        double expenditureRatio = (double) totalExpense / totalIncome * 100;
        System.out.printf("총 수입: %d\n", totalIncome);
        System.out.printf("총 지출: %d\n", totalExpense);
        System.out.printf("지출 비율: %.2f%%\n", expenditureRatio);
    }

    // 추가한 기능 - 월별 조회 메뉴 호출
    static void calculateMonthlyView() {
        System.out.println("\n---------------------------------------");
        System.out.println("1. 월별 소비 분포 조회 (현금)");
        System.out.println("2. 월별 소비 분포 조회 (카드)");
        System.out.println("3. 카테고리별 월별 지출 비율 조회");
        System.out.println("4. 전체 월별 지출 비율 조회");
        System.out.println("5. 이전 메뉴로 돌아가기");
        System.out.println("---------------------------------------");
        System.out.print("조회할 메뉴를 선택하세요: ");
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                calculateMonthlySpendingDistribution();
                break;
            case 2:
                calculateMonthlySpendingDistribution();
                break;
            case 3:
                calculateMonthlyExpenditureByCategory();
                break;
            case 4:
                calculateMonthlyExpenditureRatio();
                break;
            case 5:
                break;
            default:
                System.out.println("잘못된 메뉴 선택입니다. 다시 선택하세요.");
                calculateMonthlyView();
        }
    }

    // 추가한 기능 - 카테고리별 월별 지출 비율을 계산하여 출력
    static void calculateMonthlyExpenditureByCategory() {
        Map<String, Map<String, Integer>> categoryMonthlyExpenses = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String[] dateParts = date[i].split("-");
            String yearMonth = dateParts[0] + "-" + dateParts[1];
            String currentCategory = category[i];
            int currentExpense = price[i];

            if (currentExpense < 0) {
                Map<String, Integer> categoryExpenses = categoryMonthlyExpenses.getOrDefault(currentCategory, new HashMap<>());
                int currentCategoryExpense = categoryExpenses.getOrDefault(yearMonth, 0);
                categoryExpenses.put(yearMonth, currentCategoryExpense - currentExpense);
                categoryMonthlyExpenses.put(currentCategory, categoryExpenses);
            }
        }

        System.out.println("\n---------------------------------------");
        System.out.println("카테고리별 월별 지출 내역");
        System.out.println("---------------------------------------");

        for (Map.Entry<String, Map<String, Integer>> categoryEntry : categoryMonthlyExpenses.entrySet()) {
            String category = categoryEntry.getKey();
            System.out.println(category + " 카테고리");
            for (Map.Entry<String, Integer> entry : categoryEntry.getValue().entrySet()) {
                String yearMonth = entry.getKey();
                int categoryExpense = entry.getValue();
                System.out.printf("%s: %d원\n", yearMonth, categoryExpense);
            }
            System.out.println("---------------------------------------");
        }
    }
}
