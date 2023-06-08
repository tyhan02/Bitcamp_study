package App1_9;

public class App1 {
    public String getGreeting() {
        return "도서 관리 시스템";
    } //도서 추가 삭제

    public static void main(String[] args) {
        System.out.println(new App1().getGreeting());
    }
}
