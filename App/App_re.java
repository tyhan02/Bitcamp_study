import handler.BoardHandler;
import handler.Handler;
import handler.MemberHandler;
import util.Prompt;
import util.ArrayList;
import util.LinkedList;
import util.MenuPrompt;


public class App_re {

    public static void main(String[] args) {

        MenuPrompt prompt = new MenuPrompt();
        prompt.appendBreadcrumb("메인", getMenu());

        Handler memberHandler = new MemberHandler(prompt, "회원", new ArrayList());
        Handler boardHandler = new BoardHandler(prompt, "게시글", new LinkedList());
        Handler readingHandler = new BoardHandler(prompt, "독서록", new LinkedList());

        printTitle();

        prompt.printMenu();

        loop: while (true) {
            String menuNo = prompt.inputMenu();
            switch (menuNo) {
                case "0": break loop;
                case "1": memberHandler.execute(); break;
                case "2": boardHandler.execute(); break;
                case "3": readingHandler.execute(); break;
            }
        }

        prompt.close();
    }

    static String getMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("1. 회원\n");
        menu.append("2. 게시글\n");
        menu.append("3. 독서록\n");
        menu.append("0. 종료\n");
        return menu.toString();
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }
}