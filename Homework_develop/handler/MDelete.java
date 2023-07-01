package handler;

import java.util.List;
import vo.Member;
import util.BPrompt;

public class MDelete extends AbstractMemberL {

  public MDelete(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BPrompt prompt) {
    if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

}
