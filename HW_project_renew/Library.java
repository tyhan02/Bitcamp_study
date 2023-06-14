import java.util.Arrays;
import java.util.Scanner;

public class Library {
    private Board[] boards;
    private int boardCount;
    private Scanner scanner;

    public Library() {
        boards = new Board[100];
        boardCount = 0;
        scanner = new Scanner(System.in);
    }

    public void addBoard() {
        System.out.println("게시글 등록을 선택하셨습니다.");
        System.out.print("게시글 제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("작성자를 입력하세요: ");
        String writer = scanner.nextLine();
        System.out.print("내용을 입력하세요: ");
        String content = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        Board board = new Board(title, writer, content, password);
        boards[boardCount++] = board;
        System.out.println("게시글이 등록되었습니다.");
    }

    public void displayBoards() {
        System.out.println("게시글 목록을 선택하셨습니다.");
        if (boardCount == 0) {
            System.out.println("등록된 게시글이 없습니다.");
            return;
        }
        for (int i = 0; i < boardCount; i++) {
            System.out.println(boards[i].getTitle());
        }
    }

    public void searchBoard() {
        System.out.println("게시글 조회를 선택하셨습니다.");
        if (boardCount == 0) {
            System.out.println("등록된 게시글이 없습니다.");
            return;
        }
        System.out.print("게시글 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < boardCount; i++) {
            if (boards[i].getTitle().equals(searchTitle)) {
                System.out.println("게시글 제목: " + boards[i].getTitle());
                System.out.println("작성자: " + boards[i].getWriter());
                System.out.println("내용: " + boards[i].getContent());
                return;
            }
        }

        System.out.println("일치하는 게시글이 없습니다.");
    }

    public void updateBoard() {
        System.out.println("게시글 변경을 선택하셨습니다.");
        if (boardCount == 0) {
            System.out.println("등록된 게시글이 없습니다.");
            return;
        }
        System.out.print("게시글 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < boardCount; i++) {
            if (boards[i].getTitle().equals(searchTitle)) {
                System.out.print("새로운 게시글 제목을 입력하세요: ");
                String newTitle = scanner.nextLine();
                System.out.print("새로운 작성자를 입력하세요: ");
                String newWriter = scanner.nextLine();
                System.out.print("새로운 내용을 입력하세요: ");
                String newContent = scanner.nextLine();

                boards[i].setTitle(newTitle);
                boards[i].setWriter(newWriter);
                boards[i].setContent(newContent);

                System.out.println("게시글이 변경되었습니다.");
                return;
            }
        }

        System.out.println("일치하는 게시글이 없습니다.");
    }

    public void deleteBoard() {
        System.out.println("게시글 삭제를 선택하셨습니다.");
        if (boardCount == 0) {
            System.out.println("등록된 게시글이 없습니다.");
            return;
        }
        System.out.print("게시글 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < boardCount; i++) {
            if (boards[i].getTitle().equals(searchTitle)) {
                for (int j = i; j < boardCount - 1; j++) {
                    boards[j] = boards[j + 1];
                }
                boardCount--;
                System.out.println("게시글이 삭제되었습니다.");
                return;
            }
        }

        System.out.println("일치하는 게시글이 없습니다.");
    }

    public void addReadingRecord() {
    }

    public void displayReadingRecords() {
    }

    public void searchReadingRecord() {
    }

    public void updateReadingRecord() {
    }

    public void deleteReadingRecord() {
    }
}