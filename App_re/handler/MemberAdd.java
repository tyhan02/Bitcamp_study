package handler;


import util.BPrompt;
import vo.Member;

import java.util.List;

public class MemberAdd extends AbstractMember {

    public MemberAdd(List<Member> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        Member m = new Member();
        m.setName(prompt.inputString("이름? "));
        m.setEmail(prompt.inputString("이메일? "));
        m.setPassword(prompt.inputString("암호? "));
        m.setGender(inputGender((char)0, prompt));

        this.list.add(m);
    }
}