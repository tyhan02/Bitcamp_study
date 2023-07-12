package Project8;
import Project8.util.Prompt;
import Project8.handler.MemberHandler;
import java.util.Scanner;

public class Money {

    public static void main(String[] args) {

        printTitle();

        while (MemberHandler.available()) {
            MemberHandler.inputMember();
            if (!promptContinue()) {
                break;
            }
        }

        MemberHandler.printMembers();

        Prompt.close();
    }


    static void printTitle() {
        System.out.println("나의 용돈 관리 시스템");
        System.out.println("----------------------------------");
    }


    static boolean promptContinue() {

        String response = Prompt.inputString("계속 하시겠습니까?(Y/n)");
        if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }
}

