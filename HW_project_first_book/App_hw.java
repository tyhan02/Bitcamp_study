import java.util.Scanner;

public class App_hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        Library library = new Library();
        int choice;

        while (true) {
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록");
            System.out.println("3. 도서 조회");
            System.out.println("4. 도서 변경");
            System.out.println("5. 도서 삭제");
            System.out.println("6. 게시글 등록");
            System.out.println("7. 게시글 목록");
            System.out.println("8. 게시글 조회");
            System.out.println("9. 게시글 변경");
            System.out.println("10. 게시글 삭제");
            System.out.println("11. 독서록 등록");
            System.out.println("12. 독서록 목록");
            System.out.println("13. 독서록 조회");
            System.out.println("14. 독서록 변경");
            System.out.println("15. 독서록 삭제");
            System.out.println("99. 종료");
            System.out.print("메뉴를 선택하세요: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    bookManager.addBook();
                    break;
                case 2:
                    bookManager.displayBooks();
                    break;
                case 3:
                    bookManager.searchBook();
                    break;
                case 4:
                    bookManager.updateBook();
                    break;
                case 5:
                    bookManager.deleteBook();
                    break;
                case 6:
                    library.addBoard();
                    break;
                case 7:
                    library.displayBoards();
                    break;
                case 8:
                    library.searchBoard();
                    break;
                case 9:
                    library.updateBoard();
                    break;
                case 10:
                    library.deleteBoard();
                    break;
                case 11:
                    library.addReadingRecord();
                    break;
                case 12:
                    library.displayReadingRecords();
                    break;
                case 13:
                    library.searchReadingRecord();
                    break;
                case 14:
                    library.updateReadingRecord();
                    break;
                case 15:
                    library.deleteReadingRecord();
                    break;
                case 99:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 입력하세요.");
                    break;
            }
        }
    }
}
