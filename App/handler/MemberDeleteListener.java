package handler;

import util.BreadcrumbPrompt;
import vo.Member;

import java.util.List;

public class MemberDeleteListener extends AbstractMemberListener {

    public MemberDeleteListener(List<Member> list) {
        super(list);
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
            System.out.println("해당 번호의 회원이 없습니다!");
        }
    }

}