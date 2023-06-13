package handler;

import util.Prompt;

import java.util.Date;


public class BoardHandler {
    static final int MAX_SIZE = 100;
    static Board[] boards = new Board[MAX_SIZE];
    static int length = 0;



    public static void inputBoard() {
        if (!available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }

        Board board = new Board();
        board.setTitle(Prompt.inputString("제목?"));
        board.setContent(Prompt.inputString("글 내용? "));
        board.setWriter(Prompt.inputString("작성자? "));
        board.setPassword(Prompt.inputString("암호? "));
        
        boards[length++] = board;
    }

    public static void printBoard() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 제목, 작성자, 조회수, 등록일");
        System.out.println("---------------------------------------");

        for (int i=0; i<length; i++){
            Board board = boards[i];
        }

        Date date = new Date((board.getCreatedDate()));

        for (int i = 0; i < length; i++) {
            Board board = boards[i];
            System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n",
                    board.getNo(),
                    board.getTitle(),
                    board.getWriter(),
                    board.getViewCount(),
                    board.getCreatedDate());
        }
    }



    public static void viewBoard() {
        String memberNo = Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            Board board = boards[i];
            if (board.getNo() == Integer.parseInt(memberNo)) {
                System.out.printf("이름: %s\n", board.getName(Prompt.inputString("이름?")));
                System.out.printf("이메일: %s\n", board.getEmail());

                return;
            }
        }
        System.out.println("해당 번호의 회원이 없습니다!");
    }
    

    public static void updateBoard() {
        String memberNo = Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            Board board = boards[i];
            if (board.getNo() == Integer.parseInt(memberNo)) {
                System.out.printf("이름(%s)? ", board.getName(Prompt.inputString("이름?")));
                board.setName(Prompt.inputString(""));
                System.out.printf("이메일(%s)? ", board.getEmail());
                board.setEmail(Prompt.inputString(""));
                System.out.printf("새암호? ");
                board.setPassword(Prompt.inputString(""));
                return;
            }
        }
        System.out.println("해당 번호의 회원이 없습니다!");
    }
    

    public static void deleteBoard() {
        int memberNo = Prompt.inputInt("번호? ");

        int deletedIndex = indexOf(memberNo);
        if (deletedIndex == -1) {
            System.out.println("해당 번호의 회원이 없습니다!");
            return;
        }

        for (int i = deletedIndex; i < length - 1; i++) {
            boards[i] = boards[i + 1];
        }

        boards[--length] = null;
    }

    private static int indexOf(int memberNo) {
        for (int i = 0; i < length; i++) {
            Board board = boards[i];
            if (board.getNo() == memberNo) {
                return i;
            }
        }
        return -1;
    }

    private static boolean available() {
        return length < MAX_SIZE;
    }


}
