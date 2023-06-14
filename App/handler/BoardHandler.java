package handler;

import util.Board;
import util.Prompt;

import java.util.Date;


public class BoardHandler {
    // 인스턴스에 상관없이 공통으로 사용하는 필드라면 스태틱 필드로 선언
    private static final int MAX_SIZE = 100;
    //인스턴스 마다 별개로 관리해야 하는 데이터라면 논스태틱 필드(인스턴스 필드)로 선언한다
    private Board[] boards = new Board[MAX_SIZE];
    private int length = 0;


    //인스턴스 멤버(필드나 메서드)를 사용하는 경우 인스턴스 메서드로 정의해야한다
    public void inputBoard() {
        if (!this.available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }

        Board board = new Board();
        board.setTitle(Prompt.inputString("제목?"));
        board.setContent(Prompt.inputString("글 내용? "));
        board.setWriter(Prompt.inputString("작성자? "));
        board.setPassword(Prompt.inputString("암호? "));
        
        this.boards[this.length++] = board;
    }

    public void printBoard() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 제목, 작성자, 조회수, 등록일");
        System.out.println("---------------------------------------");

        for (int i = 0; i < this.length; i++){
            Board board = this.boards[i];
        }

        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n",
                    board.getNo(),
                    board.getTitle(),
                    board.getWriter(),
                    board.getViewCount(),
                    board.getCreatedDate());
        }
    }



    public void viewBoard() {
        String boardNo = Prompt.inputString("번호? ");
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == Integer.parseInt(boardNo)) {
                System.out.printf("제목: %s\n", board.getTitle());
                System.out.printf("내용: %s\n", board.getContent());
                System.out.printf("작성자: %s\n", board.getWriter());
                System.out.printf("조회수: %s\n", board.getViewCount());
                System.out.printf("등록일: %tY-%1$tm-%1$td\n", board.getCreatedDate());
                board.setViewCount(board.getViewCount() +1);

                return;
            }
        }
        System.out.println("해당 번호의 게시글이 없습니다!");
    }
    

    public void updateBoard() {
        String boardNo = Prompt.inputString("번호? ");
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == Integer.parseInt(boardNo)) {
                if(!Prompt.inputString("암호?").equals(board.getPassword())){
                    System.out.println("암호 틀렸어 돌아가 안돼 안열어줘");
                    return;
                }

                board.setTitle(Prompt.inputString("제목(%s)? ", board.getTitle()));
                board.setContent(Prompt.inputString("글 내용(%s)? ", board.getContent()));
                return;
            }
        }
        System.out.println("해당 번호의 게시글이 없습니다!");
    }
    

    public void deleteBoard() {
        int deletedIndex = indexOf(Prompt.inputInt("번호? ")); //replace temp with query
        if (deletedIndex == -1) {
            System.out.println("해당 번호의 게시글이 없습니다!");
            return;
        }

        for (int i = deletedIndex; i < this.length - 1; i++) {
            this.boards[i] = this.boards[i + 1];
        }

        this.boards[--this.length] = null;
    }

    private int indexOf(int boardNo) {
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == boardNo) {
                return i;
            }
        }
        return -1;
    }

    private static boolean available() {
        return length < MAX_SIZE;
    }


}