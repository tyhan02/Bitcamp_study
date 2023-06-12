package handler;

import util.Prompt;


public class MemberHandler {
    static final int MAX_SIZE = 100;
    static Member[] members = new Member[MAX_SIZE];
    static int userId = 1;
    static int length = 0;

    static final char MALE = 'M';
    static final char FEMALE = 'W';

    public static void inputMember() {
        if (!available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }

        Member m = new Member();
        m.getName(Prompt.inputString("이름?"));
        m.setEmail(Prompt.inputString("이메일? "));
        m.setPassword(Prompt.inputString("암호? "));
        m.setGender(inputGender((char)0));
        m.setNo(userId++);

        // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
        // 레퍼런스 배열에 담는다.
        members[length++] = m;
    }

    public static void printMembers() {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            Member m = members[i];
            System.out.printf("%d, %s, %s, %s\n",
                    m.getNo(), m.getName(Prompt.inputString("이름?")), m.getEmail(),
                    toGenderString(m.getGender()));
        }
    }

    public static void viewMember() {
        String memberNo = Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            Member m = members[i];
            if (m.getNo() == Integer.parseInt(memberNo)) {
                System.out.printf("이름: %s\n", m.getName(Prompt.inputString("이름?")));
                System.out.printf("이메일: %s\n", m.getEmail());
                System.out.printf("성별: %s\n", toGenderString(m.getGender()));
                return;
            }
        }
        System.out.println("해당 번호의 회원이 없습니다!");
    }

    public static String toGenderString(char gender) {
        return gender == 'M' ? "남성" : "여성";
    }

    public static void updateMember() {
        String memberNo = Prompt.inputString("번호? ");
        for (int i = 0; i < length; i++) {
            Member m = members[i];
            if (m.getNo() == Integer.parseInt(memberNo)) {
                System.out.printf("이름(%s)? ", m.getName(Prompt.inputString("이름?")));
                m.setName(Prompt.inputString(""));
                System.out.printf("이메일(%s)? ", m.getEmail());
                m.setEmail(Prompt.inputString(""));
                System.out.printf("새암호? ");
                m.setPassword(Prompt.inputString(""));
                m.setGender(inputGender(m.getGender()));
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
            String menuNo = Prompt.inputString(label +
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
        int memberNo = Prompt.inputInt("번호? ");

        int deletedIndex = indexOf(memberNo);
        if (deletedIndex == -1) {
            System.out.println("해당 번호의 회원이 없습니다!");
            return;
        }

        for (int i = deletedIndex; i < length - 1; i++) {
            members[i] = members[i + 1];
        }

        members[--length] = null;
    }

    private static int indexOf(int memberNo) {
        for (int i = 0; i < length; i++) {
            Member m = members[i];
            if (m.getNo() == memberNo) {
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