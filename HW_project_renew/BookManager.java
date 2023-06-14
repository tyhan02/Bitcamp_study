import java.util.Arrays;
import java.util.Scanner;

public class BookManager {
    private Book[] books;
    private int bookCount;
    private Scanner scanner;

    public BookManager() {
        books = new Book[100];
        bookCount = 0;
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.println("도서 등록을 선택하셨습니다.");
        System.out.print("도서 제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("저자를 입력하세요: ");
        String author = scanner.nextLine();
        System.out.print("출판사를 입력하세요: ");
        String publisher = scanner.nextLine();
        System.out.print("출판 연도를 입력하세요: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book book = new Book(title, author, publisher, publicationYear);
        books[bookCount++] = book;
        System.out.println("도서가 등록되었습니다.");
    }

    public void displayBooks() {
        System.out.println("도서 목록을 선택하셨습니다.");
        if (bookCount == 0) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].getTitle());
        }
    }

    public void searchBook() {
        System.out.println("도서 조회를 선택하셨습니다.");
        if (bookCount == 0) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        System.out.print("도서 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(searchTitle)) {
                System.out.println("도서 제목: " + books[i].getTitle());
                System.out.println("저자: " + books[i].getAuthor());
                System.out.println("출판사: " + books[i].getPublisher());
                System.out.println("출판 연도: " + books[i].getPublicationYear());
                return;
            }
        }

        System.out.println("일치하는 도서가 없습니다.");
    }

    public void updateBook() {
        System.out.println("도서 변경을 선택하셨습니다.");
        if (bookCount == 0) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        System.out.print("도서 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(searchTitle)) {
                System.out.print("새로운 도서 제목을 입력하세요: ");
                String newTitle = scanner.nextLine();
                System.out.print("새로운 저자를 입력하세요: ");
                String newAuthor = scanner.nextLine();
                System.out.print("새로운 출판사를 입력하세요: ");
                String newPublisher = scanner.nextLine();
                System.out.print("새로운 출판 연도를 입력하세요: ");
                int newPublicationYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                books[i].setPublisher(newPublisher);
                books[i].setPublicationYear(newPublicationYear);

                System.out.println("도서가 변경되었습니다.");
                return;
            }
        }

        System.out.println("일치하는 도서가 없습니다.");
    }

    public void deleteBook() {
        System.out.println("도서 삭제를 선택하셨습니다.");
        if (bookCount == 0) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        System.out.print("도서 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(searchTitle)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("도서가 삭제되었습니다.");
                return;
            }
        }

        System.out.println("일치하는 도서가 없습니다.");
    }
}
