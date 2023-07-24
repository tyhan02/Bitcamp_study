package Project9.handler;


import Project9.util.Prompt;

import java.awt.im.spi.InputMethod;

public class MemberHandler {
    static final int MAX_SIZE = 100;
    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static int[] price = new int[MAX_SIZE];
    static char[] method = new char[MAX_SIZE];
    static char[] category = new char[MAX_SIZE];
    static int userId = 1;
    static int length = 0;
    static final char CASH = 'M';
    static final char CARD = 'W';
    public static void inputMember() {

        if (!available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }

        name[length] = Prompt.inputString("품목?: ");
        price[length] = Integer.parseInt(Prompt.inputString("가격?: "));
        method[length] = InputMethod((char)0);
        category[length] = InputCategory((char)0);

        public static void printMembers() {
            System.out.println("---------------------------------------");
            System.out.println("번호, 이름, 가격, 품목, 카테고리");
            System.out.println("---------------------------------------");

            for (int i = 0; i < length; i++) {
                System.out.printf("%d, %s, %d, %s, %s\n",
                        no[i], name[i], price[i],
                        toMethodString(method[i]),
                        toCategoryString(category[i]));
            }
        }

        public static void viewMember() {
            String memberNo= Prompt.inputString("번호? ");
            for (int i = 0; i < length; i++) {
                if (no[i] == Integer.parseInt(memberNo)) {
                    System.out.printf("이름: %s\n", name[i]);
                    System.out.printf("가격: %s\n", price[i]);
                    System.out.printf("거래수단: %s\n", toMethodString(method[i])
                    System.out.printf("카테고리: %s\n", toCategoryString(category[i]));
                    return;
                }
            }
            System.out.println("해당 번호의 회원이 없습니다!");
        }
        public static String toMethodString(String method) {
            return method == 'CARD' ? "카드" : "현금";
        }

        public static void updateMember(){
            String MemberNO = Prompt.inputString("번호? ");
            for (int i = 0; i < length; i++) {
                if (no[i] == Integer.parseInt(memberNo)) {
                    System.out.printf("이름(%s)? ", name[i]);
                    name[i] = Prompt.inputString("");
                    System.out.printf("가격(%s)? ", price[i]);
                    price[i] = Prompt.inputString("");
                    method[i] = inputMethod(method[i]);
                    return;
                }
            }
            System.out.println("해당 번호의 회원이 없습니다!");

        }

        private static char inputMethod(char method){
            String label;
            if (method == 0){
                label = "거래수단\n";
            }else{
             label = String.format("거래수단(%s)\n", toMethodString(method));
            }
            loop: while (true) {
                String menu1 = Prompt.inputString(label +
                        "1. 현금\n" +
                        "2. 카드\n" +
                        "> ");

                switch (menu1) {
                    case "1":
                       return CASH;
                    case "2":
                        return CARD;

                    default:
                        System.out.println("무효한 번호입니다.");
                }

            }
        }
        private static char toCategoryString(String category){
            String label;
            if (category == 0){
                label = "카테고리\n";
            }else{
                label = String.format("카테고리(%s)\n", toCategoryString(category);
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

        public static void deleteMember() {
            int memberNo = Prompt.inputInt("번호? ");

            int deletedIndex = indexOf(memberNo);
            if (deletedIndex == -1) {
                System.out.println("해당 번호의 회원이 없습니다!");
                return;
            }

            for (int i = deletedIndex; i < length - 1; i++) {
                no[i] = no[i + 1];
                name[i] = name[i + 1];
                email[i] = email[i + 1];
                password[i] = password[i + 1];
                gender[i] = gender[i + 1];
            }

            no[length - 1] = 0;
            name[length - 1] = null;
            email[length - 1] = null;
            password[length - 1] = null;
            gender[length - 1] = (char) 0;

            length--;
        }

        private static int indexOf(int memberNo) {
            for (int i = 0; i < length; i++) {
                if (no[i] == memberNo) {
                    return i;
                }
            }
            return -1;
        }


        public static boolean available() {
            return length < MAX_SIZE;
        }
    }
}
