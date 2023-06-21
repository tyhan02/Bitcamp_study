import handler.*;
import util.*;

import java.util.ArrayList;


public class App_re {

    public static void main(String[] args) {

        ArrayList memberList = new ArrayList();
        LinkedList boardList = new LinkedList();
        LinkedList readingList = new LinkedList();

        BreadcrumbPrompt prompt = new BreadcrumbPrompt();

        MenuGroup mainMenu = new MenuGroup("메인");

        MenuGroup memberMenu = new MenuGroup("회원");
        memberMenu.add(new Menu("등록", new MemberAddListener((List) memberList)));
        memberMenu.add(new Menu("목록", new MemberListListener((List) memberList)));
        memberMenu.add(new Menu("조회", new MemberDetailListener((List) memberList)));
        memberMenu.add(new Menu("변경", new MemberUpdateListener((List) memberList)));
        memberMenu.add(new Menu("삭제", new MemberDeleteListener((List) memberList)));
        mainMenu.add(memberMenu);

        MenuGroup boardMenu = new MenuGroup("게시글");
        boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
        boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
        boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
        boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
        boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
        mainMenu.add(boardMenu);

        MenuGroup readingMenu = new MenuGroup("독서록");
        readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
        readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
        readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
        readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
        readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
        mainMenu.add(readingMenu);

        printTitle();

        mainMenu.execute(prompt);

        prompt.close();
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }
}