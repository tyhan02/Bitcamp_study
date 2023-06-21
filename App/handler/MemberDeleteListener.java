package handler;

import util.ActionListener;
import util.BreadcrumbPrompt;
import util.List;

public class MemberDeleteListener implements ActionListener {

    private List list;

    public MemberDeleteListener(List list) {
        this.list = list;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
            System.out.println("해당 번호의 회원이 없습니다!");
        }
    }

}