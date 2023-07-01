
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import java.util.*;
import handler.*;
import util.*;
import vo.*;


public class Money {

  ArrayList<goods> memberList = new ArrayList<>();
  LinkedList<Price> priceList = new LinkedList<>();
  LinkedList<Price> readingList = new LinkedList<>();

  BPrompt prompt = new BPrompt();

  MGroup mainMenu = new MGroup("메인");

  public Money() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new Money().execute();
  }

  static void printTitle() {
    System.out.println("나의 용돈 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadCsv("member.csv", memberList, goods.class);
    loadCsv("board.csv", priceList, Price.class);
    loadCsv("reading.csv", readingList, Price.class);
  }

  private void saveData() {
    saveCsv("member.csv", memberList);
    saveCsv("board.csv", priceList);
    saveCsv("reading.csv", readingList);
  }

  private void prepareMenu() {
    MGroup memberMenu = new MGroup("회원");
    memberMenu.add(new Memo("등록", new handler.MemberAdd(memberList)));
    memberMenu.add(new Memo("목록", new handler.MemberList(memberList)));
    memberMenu.add(new Memo("조회", new handler.MemberDetail(memberList)));
    memberMenu.add(new Memo("변경", new handler.MemberUpdate(memberList)));
    memberMenu.add(new Memo("삭제", new handler.MemberDelete(memberList)));
    mainMenu.add(memberMenu);

    MGroup boardMenu = new MGroup("게시글");
    boardMenu.add(new Memo("등록", new BoardAdd(priceList)));
    boardMenu.add(new Memo("목록", new handler.BoardList(priceList)));
    boardMenu.add(new Memo("조회", new BDetail(priceList)));
    boardMenu.add(new Memo("변경", new handler.BoardUpdate(priceList)));
    boardMenu.add(new Memo("삭제", new BoardDelete(priceList)));
    mainMenu.add(boardMenu);

    MGroup readingMenu = new MGroup("독서록");
    readingMenu.add(new Memo("등록", new Add(readingList)));
    readingMenu.add(new Memo("목록", new handler.BoardList(readingList)));
    readingMenu.add(new Memo("조회", new BoardDetail(readingList)));
    readingMenu.add(new Memo("변경", new BUpdate(readingList)));
    readingMenu.add(new Memo("삭제", new BDelete(readingList)));
    mainMenu.add(readingMenu);

    Memo helloMemo = new Memo("안녕!");
    helloMemo.addActionListener(new HL());
    helloMemo.addActionListener(new HeL());
    helloMemo.addActionListener(new FL());
    mainMenu.add(helloMemo);
  }

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T)factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
        // list.add(goods.fromCsv(line)); // 직접 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
        // Board나 goods 클래스에 필드가 추가/변경/삭제되더라도
        // 여기 코드를 변경할 필요가 없다.
        // 이것이 Information Expert 설계를 적용하는 이유다!
        // 설계를 어떻게 하느냐에 따라 유지보수가 쉬워질 수도 있고,
        // 어려워질 수도 있다.
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
