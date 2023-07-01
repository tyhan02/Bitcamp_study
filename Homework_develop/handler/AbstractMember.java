package handler;

import java.util.List;
import vo.goods;
import util.ActionL;
import util.BPrompt;

public abstract class AbstractMember implements ActionL {

  protected List<goods> list;

  public AbstractMember(List<goods> list) {
    this.list = list;
  }

  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  protected goods findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      goods m = this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  protected char inputGender(char gender, BPrompt prompt) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = prompt.inputString(label +
          "  1. 남자\n" +
          "  2. 여자\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return goods.CASH;
        case "2":
          return goods.CARD;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

}
