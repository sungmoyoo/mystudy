package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Prompt prompt;
  protected Menu menu;

  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void action(Menu menu) {
    this.printMenuTitle(menu.getTitle());
    this.menu = menu;
    action();
  }

  public abstract void action();

  public void printMenuTitle(String title) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }
}
