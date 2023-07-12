package Project8.handler;


import Project8.util.Prompt;

public class MemberHandler {
    static final int MAX_SIZE = 100;
    static int userId = 1;
    static int length = 0;

    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static int[] price = new int[MAX_SIZE];
    static String[] method = new String[MAX_SIZE];
    static String[] category = new String[MAX_SIZE];
    public static void inputMember() {

        name[length] = Prompt.inputString("품목?: ");
        price[length] = Integer.parseInt(Prompt.inputString("가격?: "));

        loop: while (true) {
            String menu1 = Prompt.inputString("결재수단 : \n" +
                    "1. 현금\n" +
                    "2. 카드\n" +
                    "> ");

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

        loop: while (true) {

            String menu2 = Prompt.inputString("카테고리:\n" +
                    "  1. 식사\n" +
                    "  2. 술\n" +
                    "  3. 쇼핑\n" +
                    "  4. 교통\n" +
                    "  5. 생활\n" +
                    "  6. 기타\n" +
                    "> ");

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
    public static void printMembers() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 가격, 품목, 카테고리");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %s, %s\n", no[i], name[i], price[i], method[i], category[i]);
        }
    }
    public static boolean available() {return length < MAX_SIZE;}
}
