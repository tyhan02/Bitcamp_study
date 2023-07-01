package handler;

import util.BPrompt;
import vo.Member;

import java.util.List;

public class MemberDelete extends AbstractMember {

    public MemberDelete(List<Member> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
            System.out.println("해당 번호의 회원이 없습니다!");
        }
    }

}