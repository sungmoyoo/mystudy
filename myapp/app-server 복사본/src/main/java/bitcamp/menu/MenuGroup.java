package bitcamp.menu;

import bitcamp.util.Prompt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();

  private MenuGroup(String title, Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  public static MenuGroup getInstance(String title) {
    return new MenuGroup(title, new Stack<String>());
  }

  @Override
  public void execute(Prompt prompt) throws Exception {

    breadcrumb.push(this.title);

    this.printMenu(prompt);

    while (true) {
      String input = prompt.input("%s>", this.getMenuPath());

      if (input.equals("menu")) {
        this.printMenu(prompt);
        continue;
      } else if (input.equals("0")) {
        break;
      }

      try {
        int menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menus.size()) {
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }

        this.menus.get(menuNo - 1).execute(prompt);

      } catch (Exception e) {
        System.out.println("메뉴가 옳지 않습니다!");
      }
    }

    // 메뉴를 나갈 때 breadcrumb 메뉴 경로에서 메뉴 제목을 제거한다.
    breadcrumb.pop();
  }

  private void printMenu(Prompt prompt) {
    prompt.printf("[%s]\n", this.getTitle());

    Iterator<Menu> iterator = this.menus.iterator();
    int i = 1;
    while (iterator.hasNext()) {
      Menu menu = iterator.next();
      prompt.printf("%d. %s\n", i++, menu.getTitle());
    }

    prompt.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public MenuItem addItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, this.breadcrumb, handler);
    this.add(menuItem);
    return menuItem;
  }

  public MenuGroup addGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title, this.breadcrumb);
    this.add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }
}
