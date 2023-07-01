package handler;

import java.util.List;
import vo.Price;
import util.BPrompt;

public class BDelete extends AbstractBoard {

  public BDelete(List<Price> list) {
    super(list);
  }

  @Override
  public void service(BPrompt prompt) {
    if (!this.list.remove(new Price(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}











