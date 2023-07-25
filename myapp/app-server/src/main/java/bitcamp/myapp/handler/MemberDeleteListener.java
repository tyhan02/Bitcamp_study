package bitcamp.myapp.handler;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

import java.io.IOException;

public class MemberDeleteListener implements ActionListener {

  MemberDao memberDao;

  public MemberDeleteListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {

    if (memberDao.delete(prompt.inputInt("번호? ")) == 0) {
      prompt.println("해당 번호의 회원이 없습니다!");
    }
    prompt.println("삭제 완료");
    }
  }