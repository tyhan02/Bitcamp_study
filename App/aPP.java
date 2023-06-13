public class aPP {

    public static void main(String[] args) {

        printTitle();

        printMenu();

        while (true) {
            String menuNo = util.Prompt.inputString("메인> ");
            if (menuNo.equals("6")) {
                break;
            } else if (menuNo.equals("menu")) {
                printMenu();
            } else if (menuNo.equals("1")) {
                handler.MemberHandler.inputMember();
            } else if (menuNo.equals("2")) {
                handler.MemberHandler.printMembers();
            } else if (menuNo.equals("3")) {
                handler.MemberHandler.viewMember();
            } else if (menuNo.equals("4")) {
                handler.MemberHandler.updateMember();
            } else if (menuNo.equals("5")) {
                handler.MemberHandler.deleteMember();
            } else {
                System.out.println(menuNo);
            }
        }

        util.Prompt.close();
    }

    static void printMenu() {
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록");
        System.out.println("3. 회원조회");
        System.out.println("4. 회원변경");
        System.out.println("5. 회원삭제");
        System.out.println("6. 종료");
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }

}
