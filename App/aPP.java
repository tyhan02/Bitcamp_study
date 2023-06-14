import handler.BoardHandler;

public class aPP {

    public static void main(String[] args) {


        BoardHandler boardHandler = new BoardHandler();
        BoardHandler readingHandler = new BoardHandler();

        printTitle();

        printMenu();



        while (true) {
            String menuNo = util.Prompt.inputString("메인> ");
            if (menuNo.equals("99")) {
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
            } else if (menuNo.equals("6")) {
                handler.BoardHandler.inputBoard();
            } else if (menuNo.equals("7")) {
                handler.BoardHandler.printBoard();
            } else if (menuNo.equals("8")) {
                handler.BoardHandler.viewBoard();
            } else if (menuNo.equals("9")) {
                handler.BoardHandler.updateBoard();
            } else if (menuNo.equals("10")) {
                handler.BoardHandler.deleteBoard();
            } else if (menuNo.equals("11")) {
                handler.readingHandler.inputBoard();
            } else if (menuNo.equals("12")) {
                handler.readingHandler.printBoard();
            } else if (menuNo.equals("13")) {
                handler.readingHandler.viewBoard();
            } else if (menuNo.equals("14")) {
                handler.readingHandler.updateBoard();
            } else if (menuNo.equals("15")) {
                handler.readingHandler.deleteBoard();
            }
            else {
                System.out.println(menuNo);
            }
        }

        util.Prompt.close();
    }

    static void printMenu() {
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 목록");
        System.out.println("3. 회원 조회");
        System.out.println("4. 회원 변경");
        System.out.println("5. 회원 삭제");
        System.out.println("6. 게시글 등록");
        System.out.println("7. 게시글 목록");
        System.out.println("8. 게시글 조회");
        System.out.println("9. 게시글 변경");
        System.out.println("10. 게시글삭제");
        System.out.println("11. 독서록 등록");
        System.out.println("12. 독서록 목록");
        System.out.println("13. 독서록 조회");
        System.out.println("14. 독서록 변경");
        System.out.println("15. 독서록 삭제");
        System.out.println("99. 종료");
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }

}
