import handler.BoardAddListener;
import handler.BoardDeleteListener;
import handler.BoardDetailListener;
import handler.BoardListListener;
import handler.BoardUpdateListener;
import handler.FooterListener;
import handler.HeaderListener;
import handler.HelloListener;
import handler.MemberAddListener;
import handler.MemberDeleteListener;
import handler.MemberDetailListener;
import handler.MemberListListener;
import handler.MemberUpdateListener;
import util.BreadcrumbPrompt;
import util.*;
import handler.*;
import handler.Board;
import util.MenuGroup;
import java.util.ArrayList;
import java.util.LinkedList;


public class App_re {


    ArrayList<Member> memberList = new ArrayList<>();
    LinkedList<Board> boardList = new LinkedList<>();
    LinkedList<Board> readingList = new LinkedList<>();

    BreadcrumbPrompt prompt = new BreadcrumbPrompt();

    MenuGroup  mainMenu = new MenuGroup("메인");

    public  App_re() {
        prepareMenu();

    }

    public void execute(){
        printTitle();

        mainMenu.execute(prompt);

        prompt.close();

    }

    private void prepareMenu() {
    MenuGroup mainMenu = new MenuGroup("메인");

        MenuGroup memberMenu = new MenuGroup("회원");
        memberMenu.add(new

                Menu("등록",new MemberAddListener(memberList)));
        memberMenu.add(new

                Menu("목록",new MemberListListener(memberList)));
        memberMenu.add(new

                Menu("조회",new MemberDetailListener(memberList)));
        memberMenu.add(new

                Menu("변경",new MemberUpdateListener(memberList)));
        memberMenu.add(new

                Menu("삭제",new MemberDeleteListener(memberList)));
        mainMenu.add(memberMenu);

        MenuGroup boardMenu = new MenuGroup("게시글");
        boardMenu.add(new

                Menu("등록",new BoardAddListener(boardList)));
        boardMenu.add(new

                Menu("목록",new BoardListListener(boardList)));
        boardMenu.add(new

                Menu("조회",new BoardDetailListener(boardList)));
        boardMenu.add(new

                Menu("변경",new BoardUpdateListener(boardList)));
        boardMenu.add(new

                Menu("삭제",new BoardDeleteListener(boardList)));
        mainMenu.add(boardMenu);

        MenuGroup readingMenu = new MenuGroup("독서록");
        readingMenu.add(new

                Menu("등록",new BoardAddListener(readingList)));
        readingMenu.add(new

                Menu("목록",new BoardListListener(readingList)));
        readingMenu.add(new

                Menu("조회",new BoardDetailListener(readingList)));
        readingMenu.add(new

                Menu("변경",new BoardUpdateListener(readingList)));
        readingMenu.add(new

                Menu("삭제",new BoardDeleteListener(readingList)));
        mainMenu.add(readingMenu);

        Menu helloMenu = new Menu("안녕!");
        helloMenu.addActionListener(new

                HeaderListener());
        helloMenu.addActionListener(new

                HelloListener());
        helloMenu.addActionListener(new

                FooterListener());
        mainMenu.add(helloMenu);

    }
    public static void main(String[] args) {
        App_re app  =  new App_re();
        app.execute();
    }




    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }
}