package handler;

import util.BPrompt;
import vo.Member;

import java.util.List;


public class MemberDetail extends AbstractMember {

    public MemberDetail(List<Member> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        int memberNo = prompt.inputInt("번호? ");

        Member m = this.findBy(memberNo);
        if (m == null) {
            System.out.println("해당 번호의 회원이 없습니다!");
            return;
        }

        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
    }
}