package handler;

import util.ActionListener;
import util.BreadcrumbPrompt;
import util.List;

public class MemberListListener implements ActionListener {

    private List list;

    public MemberListListener(List list) {
        this.list = list;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        for (int i = 0; i < this.list.size(); i++) {
            Member m = (Member) this.list.get(i);
            System.out.printf("%d, %s, %s, %s\n",
                    m.getNo(), m.getName(), m.getEmail(),
                    toGenderString(m.getGender()));
        }
    }

    private static String toGenderString(char gender) {
        return gender == 'M' ? "남성" : "여성";
    }

}