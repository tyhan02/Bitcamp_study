package util;

import java.util.ArrayList;

public class Memo {

  private String title;
  private ArrayList<ActionL> listeners = new ArrayList<>();

  public Memo(String title) {
    this.title = title;
  }

  public Memo(String title, ActionL listener) {
    this(title);
    this.addActionListener(listener);
  }

  public void addActionListener(ActionL listener) {
    listeners.add(listener);
  }

  public void removeActionListener(ActionL listener) {
    listeners.remove(listener);
  }

  public String getTitle() {
    return title;
  }

  public void execute(BPrompt prompt) {
    for (int i = 0; i < listeners.size(); i++) {
      ActionL listener = listeners.get(i);
      listener.service(prompt);
    }
  }
}
