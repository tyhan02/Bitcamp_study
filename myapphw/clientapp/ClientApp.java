package clientapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import common.RequestEntity;
import clientapp.dao.BoardDao;
import clientapp.dao.BoardNetworkDao;
import clientapp.dao.MemberDao;
import clientapp.dao.MemberNetworkDao;
import clientapp.handler.BoardAddListener;
import clientapp.handler.BoardDeleteListener;
import clientapp.handler.BoardDetailListener;
import clientapp.handler.BoardListListener;
import clientapp.handler.BoardUpdateListener;
import clientapp.handler.FooterListener;
import clientapp.handler.HeaderListener;
import clientapp.handler.HelloListener;
import clientapp.handler.MemberAddListener;
import clientapp.handler.MemberDeleteListener;
import clientapp.handler.MemberDetailListener;
import clientapp.handler.MemberListListener;
import clientapp.handler.MemberUpdateListener;
import clientapp.util.BreadcrumbPrompt;
import clientapp.util.Menu;
import clientapp.util.MenuGroup;
import com.google.gson.Gson;

public class ClientApp {

  Socket socket;
  DataOutputStream out;
  DataInputStream in;

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {

    this.socket = new Socket(ip, port);
    this.out = new DataOutputStream(socket.getOutputStream());
    this.in = new DataInputStream(socket.getInputStream());

    this.memberDao = new MemberNetworkDao("member", in, out);
    this.boardDao = new BoardNetworkDao("board", in, out);
    this.readingDao = new BoardNetworkDao("reading", in, out);

    prepareMenu();
  }

  public void close() throws Exception {
    prompt.close();
    out.close();
    in.close();
    socket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("실행 예) java ... bitcamp.myapp.ClientApp 서버주소 포트번호");
      return;
    }

    ClientApp app = new ClientApp(args[0], Integer.parseInt(args[1]));
    app.execute();
    app.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();
    mainMenu.execute(prompt);

    try {
      out.writeUTF(new Gson().toJson(
              new RequestEntity().command("quit")));

    } catch (Exception e) {
      System.out.println("종료 오류!");
      e.printStackTrace();
    }
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingDao)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingDao)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingDao)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingDao)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }
}