package Project9;
import Project9.handler.MemberHandler;
import Project9.util.Prompt;

public class Money {

    public static void main(String[] args) {

        printTitle();
        printMenu();

        while (true) {
            String menuNo = Prompt.inputString("메인> ");
            if (menuNo.equals("6")) {
                break;
            } else if (menuNo.equals("menu")) {
                printMenu();
            } else if (menuNo.equals("1")) {
                MemberHandler.inputMember();
            } else if (menuNo.equals("2")) {
                MemberHandler.printMembers();
            } else if (menuNo.equals("3")) {
                MemberHandler.viewMember();
            } else if (menuNo.equals("4")) {
                MemberHandler.updateMember();
            } else if (menuNo.equals("5")) {
                MemberHandler.deleteMember();
            } else {
                System.out.println(menuNo);
            }
        }

        Prompt.close();
    }

    static void printMenu() {
        System.out.println("1. 용돈기입");
        System.out.println("2. 지출목록");
        System.out.println("3. 지출조회");
        System.out.println("4. 지출변경");
        System.out.println("5. 지출삭제");
        System.out.println("6. 종료");
    }

    static void printTitle() {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");
    }
}
