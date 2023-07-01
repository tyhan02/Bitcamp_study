package handler;

import util.BPrompt;
import vo.Member;

import java.util.Iterator;
import java.util.List;

public class MemberList extends AbstractMember {

    public MemberList(List<Member> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        System.out.println("---------------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member m = iterator.next();
            System.out.printf("%d, %s, %s, %s\n",
                    m.getNo(), m.getName(), m.getEmail(),
                    toGenderString(m.getGender()));
        }
    }

}