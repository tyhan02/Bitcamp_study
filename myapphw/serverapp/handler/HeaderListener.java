package serverapp.handler;

import serverapp.util.ActionListener;
import serverapp.util.BreadcrumbPrompt;

public class HeaderListener implements ActionListener {
  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("=============================[비트캠프!]==");
  }
}
