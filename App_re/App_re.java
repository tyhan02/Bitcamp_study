
import handler.*;


import vo.Member;
import util.*;
import vo.Price;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App_re {

    ArrayList<Member> memberList = new ArrayList<>();
    LinkedList<Price> priceList = new LinkedList<>();
    LinkedList<Price> readingList = new LinkedList<>();

    BPrompt prompt = new BPrompt();

    MGroup mainMenu = new MGroup("메인");

    public App_re() {
        prepareMenu();
    }

    public static void main(String[] args) {
        new App_re().execute();
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
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
        loadMember("member.csv", memberList);
        loadBoard("board.csv", priceList);
        loadBoard("reading.csv", readingList);
    }

    private void saveData() {
        saveMember("member.csv", memberList);
        saveBoard("board.csv", priceList);
        saveBoard("reading.csv", readingList);
    }

    private void prepareMenu() {
        MGroup memberMenu = new MGroup("회원");
        memberMenu.add(new Memo("등록", new MAdd(memberList)));
        memberMenu.add(new Memo("목록", new MList(memberList)));
        memberMenu.add(new Memo("조회", new MDetail(memberList)));
        memberMenu.add(new Memo("변경", new MUpdate(memberList)));
        memberMenu.add(new Memo("삭제", new MDelete(memberList)));
        mainMenu.add(memberMenu);

        MGroup boardMenu = new MGroup("게시글");
        boardMenu.add(new Memo("등록", new BoardAdd(priceList)));
        boardMenu.add(new Memo("목록", new BList(priceList)));
        boardMenu.add(new Memo("조회", new BoardDetail(priceList)));
        boardMenu.add(new Memo("변경", new BoardUpdate(priceList)));
        boardMenu.add(new Memo("삭제", new BoardDelete(priceList)));
        mainMenu.add(boardMenu);

        MGroup readingMenu = new MGroup("독서록");
        readingMenu.add(new Memo("등록", new BoardAdd(readingList)));
        readingMenu.add(new Memo("목록", new BList(readingList)));
        readingMenu.add(new Memo("조회", new BoardDetail(readingList)));
        readingMenu.add(new Memo("변경", new BoardUpdate(readingList)));
        readingMenu.add(new Memo("삭제", new BoardDelete(readingList)));
        mainMenu.add(readingMenu);

        Memo helloMemo = new Memo("안녕!");
        helloMemo.addActionListener(new HL());
        helloMemo.addActionListener(new HeL());
        helloMemo.addActionListener(new FL());
        mainMenu.add(helloMemo);
    }

    private void loadMember(String filename, List<Member> list) {
        try {
            FileInputStream in0 = new FileInputStream(filename);
            BufferedInputStream in1 = new BufferedInputStream(in0); // <== Decorator 역할을 수행!
            ObjectInputStream in = new ObjectInputStream(in1); // <== Decorator 역할을 수행!

            int size = in.readShort();

            for (int i = 0; i < size; i++) {
                list.add((Member) in.readObject());
            }

            if (list.size() > 0) {
                // 데이터를 로딩한 이후에 추가할 회원의 번호를 설정한다.
                Member.userId = memberList.get(memberList.size() - 1).getNo() + 1;
            }

            in.close();

        } catch (Exception e) {
            System.out.println("회원 정보를 읽는 중 오류 발생!");
        }
    }

    private void loadBoard(String filename, List<Price> list) {
        try {
            FileReader in0 = new FileReader(filename);
            BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

            String line =null;

            while ((line = in.readLine()) !=null){
                String[] values = line.split(",");
                Price price = new Price();
                price.setNo(Integer.parseInt(values[0]));
                price.setTitle(values[1]);
                price.setContent(values[2]);
                price.setWriter(values[3]);
                price.setPassword(values[4]);
                price.setViewCount(Integer.parseInt(values[5]));
                price.setCreatedDate(Long.parseLong(values[6]));

                list.add(price);
            }


            if (list.size() > 0) {
                Price.boardNo = Math.max(
                        Price.boardNo,
                        list.get(list.size() - 1).getNo() + 1);
            }

            in.close();

        } catch (Exception e) {
            System.out.println(filename + " 파일을 읽는 중 오류 발생!");
        }
    }

    private void saveMember(String filename, List<Member> list) {
        try {
            FileWriter out0 = new FileWriter(filename);
            BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
            PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

            for (Member member : list) {
                out.printf("%d,%s,%s,%s,%c\n",
                        member.getNo(),
                        member.getName(),
                        member.getEmail(),
                        member.getPassword(),
                        member.getGender());
            }
            out.close();

        } catch (Exception e) {
            System.out.println("회원 정보를 저장하는 중 오류 발생!");
        }
    }

    private void saveBoard(String filename, List<Price> list) {
        try {
            FileWriter out0 = new FileWriter(filename);
            BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
            PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

            for (Price price : list) {
                out.println(price.toCsvString());
                // Price 클래스에 필드가 추가/삭제/변경 되더라도 여기 코드 변경 할 필요 없다
                // 이것이 Information Expert 설계 적용 이유!

            }
            out.close();

        } catch (Exception e) {
            System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
        }
    }
}