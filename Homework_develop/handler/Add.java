package handler;

import java.util.List;
import vo.Price;
import util.BPrompt;

public class Add extends AbstractBoard {

  public Add(List<Price> list) {
    super(list);
  }

  @Override
  public void service(BPrompt prompt) {
    Price price = new Price();
    price.setTitle(prompt.inputString("제목? "));
    price.setContent(prompt.inputString("내용? "));
    price.setWriter(prompt.inputString("작성자? "));
    price.setPassword(prompt.inputString("암호? "));
    this.list.add(price);
  }
}











