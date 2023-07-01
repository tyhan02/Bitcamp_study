package handler;

import java.util.List;
import vo.Price;
import util.BPrompt;

public class BUpdate extends AbstractBoardL {

  public BUpdate(List<Price> list) {
    super(list);
  }

  @Override
  public void service(BPrompt prompt) {
    int boardNo = prompt.inputInt("번호? ");

    Price price = this.findBy(boardNo);
    if (price == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    if (!prompt.inputString("암호? ").equals(price.getPassword())) {
      System.out.println("암호가 일치하지 않습니다!");
      return;
    }

    price.setTitle(prompt.inputString("제목(%s)? ", price.getTitle()));
    price.setContent(prompt.inputString("내용(%s)? ", price.getContent()));
  }
}











