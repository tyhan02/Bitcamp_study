import handler.BoardHandler;
import handler.MemberHandler;
import util.Prompt;

public class aPP {

    public static void main(String[] args) {

        Prompt prompt = new Prompt();
        MemberHandler memberHandler = new MemberHandler(prompt);
        BoardHandler boardHandler = new BoardHandler(prompt);
        BoardHandler readingHandler = new BoardHandler(prompt);

        //기본 생성자를 이용해 Prompt 인스턴스를 준비
        // 기본 생성자는 Scanner을 키보드와 연결

        printTitle();

        printMenu();



        while (true) {
            String menuNo = prompt.inputString("메인> ");
            if (menuNo.equals("99")) {
                break;
            } else if (menuNo.equals("menu")) {
                printMenu();
            } else if (menuNo.equals("1")) {
                memberHandler.inputMember();
            } else if (menuNo.equals("2")) {
               memberHandler.printMembers();
            } else if (menuNo.equals("3")) {
                memberHandler.viewMember();
            } else if (menuNo.equals("4")) {
               memberHandler.updateMember();
            } else if (menuNo.equals("5")) {
                memberHandler.deleteMember();
            } else if (menuNo.equals("6")) {
                boardHandler.inputBoard();
            } else if (menuNo.equals("7")) {
                boardHandler.printBoard();
            } else if (menuNo.equals("8")) {
                boardHandler.viewBoard();
            } else if (menuNo.equals("9")) {
                boardHandler.updateBoard();
            } else if (menuNo.equals("10")) {
               boardHandler.deleteBoard();
            } else if (menuNo.equals("11")) {
               readingHandler.inputBoard();
            } else if (menuNo.equals("12")) {
               readingHandler.printBoard();
            } else if (menuNo.equals("13")) {
               readingHandler.viewBoard();
            } else if (menuNo.equals("14")) {
                readingHandler.updateBoard();
            } else if (menuNo.equals("15")) {
                readingHandler.deleteBoard();
            }
            else {
                System.out.println(menuNo);
            }
        }

        prompt.close();
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
