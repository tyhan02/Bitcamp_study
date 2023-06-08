package handler;

import util.Prompt;

public class MemberHandler {

    static final int MAX_SIZE = 100;
    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static String[] email = new String[MAX_SIZE];
    static String[] password = new String[MAX_SIZE];
    static char[] gender = new char[MAX_SIZE];
    static int userId = 1;
    static int length = 0;

    static final char MALE = 'M';
    static final char FEMALE = 'W';

    public static void inputMember() {
        if (!available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }

        name[length] = util.Prompt.inputString("이름? ");
        email[length] = util.Prompt.inputString("이메일? ");
        password[length] = util.Prompt.inputString("암호? ");
        gender[length] = inputGender((char)0);

        no[length] = userId++;
        length++;
    }

    public static void printMembers() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %s, %s\n",
                    no[i], name[i], email[i],
                    toGenderString(gender[i]));
        }
    }

    public static void viewMember() {
        String memberNo =util.Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            if (no[i] == Integer.parseInt(memberNo)) {
                System.out.printf("이름: %s\n", name[i]);
                System.out.printf("이메일: %s\n", email[i]);
                System.out.printf("성별: %s\n", toGenderString(gender[i]));
                return;
            }
        }
        System.out.println("해당 번호의 회원이 없습니다!");
    }

    public static String toGenderString(char gender) {
        return gender == 'M' ? "남성" : "여성";
    }

    public static void updateMember() {
        String memberNo = util.Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            if (no[i] == Integer.parseInt(memberNo)) {
                System.out.printf("이름(%s)? ", name[i]);
                name[i] = util.Prompt.inputString("");
                System.out.printf("이메일(%s)? ", email[i]);
                email[i] = util.Prompt.inputString("");
                System.out.printf("새암호? ");
                password[i] = util.Prompt.inputString("");
                gender[i] = inputGender(gender[i]);
                return;
            }
        }
        System.out.println("해당 번호의 회원이 없습니다!");
    }

    private static char inputGender(char gender) {
        String label;
        if (gender == 0) {
            label = "성별?\n";
        } else {
            label = String.format("성별(%s)?\n", toGenderString(gender));
        }
        loop: while (true) {
            String menuNo = util.Prompt.inputString(label +
                    "  1. 남자\n" +
                    "  2. 여자\n" +
                    "> ");

            switch (menuNo) {
                case "1":
                    return MALE;
                case "2":
                    return FEMALE;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }
    }

    public static void deleteMember() {
        int memberNo = util.Prompt.inputInt("번호? ");

        int deletedIndex = indexOf(memberNo);
        if (deletedIndex == -1) {
            System.out.println("해당 번호의 회원이 없습니다!");
            return;
        }

        for (int i = deletedIndex; i < length - 1; i++) {
            no[i] = no[i + 1];
            name[i] = name[i + 1];
            email[i] = email[i + 1];
            password[i] = password[i + 1];
            gender[i] = gender[i + 1];
        }

        no[length - 1] = 0;
        name[length - 1] = null;
        email[length - 1] = null;
        password[length - 1] = null;
        gender[length - 1] = (char) 0;

        length--;
    }

    private static int indexOf(int memberNo) {
        for (int i = 0; i < length; i++) {
            if (no[i] == memberNo) {
                return i;
            }
        }
        return -1;
    }

    private static boolean available() {
        return length < MAX_SIZE;
    }
}



//    public static void updateMember() {
//        String a= Prompt.inputString("변경할 회원 번호를 입력하세요: ");
//        int b= Integer.parseInt(a);
//
//        int index = findMemberIndex(b);
//
//        if (index == -1) {
//            System.out.println("해당 회원을 찾을 수 없습니다.");
//            return;
//        }
//
//        System.out.println("[" + name[index] + "] 회원의 정보를 변경합니다.");
//
//        String newName = Prompt.inputString("변경할 이름: ");
//        String newEmail = Prompt.inputString("변경할 이메일: ");
//        String newPassword = Prompt.inputString("변경할 암호: ");
//
//        loop: while (true) {
//            String menuNo = Prompt.inputString("변경할 성별:\n" +
//                    "  1. 남자\n" +
//                    "  2. 여자\n" +
//                    "> ");
//
//            switch (menuNo) {
//                case "1":
//                    gender[index] = MALE;
//                    break loop;
//                case "2":
//                    gender[index] = FEMALE;
//                    break loop;
//                default:
//                    System.out.println("무효한 번호입니다.");
//            }
//        }
//
//        name[index] = newName;
//        email[index] = newEmail;
//        password[index] = newPassword;
//
//        System.out.println("회원 정보를 변경하였습니다.");
//    }