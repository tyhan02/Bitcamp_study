package handler;

import util.ActionL;
import util.BPrompt;

public class HeL implements ActionL {
  @Override
  public void service(BPrompt prompt) {
    String name = prompt.inputString("이름은? ");
    System.out.printf("%s 님 반가워요!\n", name);
  }
}
