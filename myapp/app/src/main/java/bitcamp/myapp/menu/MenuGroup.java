package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public class MenuGroup implements Menu {
  
  String title;
  Menu[] menus = new Menu[10];
  int menuSize;
  
  public MenuGroup(String title) {
    this.title = title;
  }
  
  public void execute(Prompt prompt) {
    this.printMenu();
    
    while (true) {
      String input = prompt.input("%s> ", this.title);
      
      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }
      
      int menuNo = Integer.parseInt(input);
      if (menuNo < 1 || menuNo > this.menuSize) {
        System.out.println("메뉴번호가 옳지 않습니다.");
        continue;
      }
      
      this.menus[menuNo - 1].execute(prompt);
    }
  }
  
  
  public void printMenu() {
    System.out.printf("[%s]\n", this.title);
    
    for (int i = 0; i < menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }
    
    System.out.printf("0. %s\n", "이전");
  }
  
  @Override
  public String getTitle() {
    return this.title;
  }
  
  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize / 2);
      
      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }
      
      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      this.menus = arr;
    }
    this.menus[this.menuSize++] = menu;
  }
  
  public void remove(Menu menu) {
    int index = this.indexOf(menu);
    
    for (int i = index; i < (this.menuSize - 1); i++) {
      this.menus[i] = this.menus[i + 1];
    }
    this.menus[--this.menuSize] = null;
  }
  
  int indexOf(Menu menu) {
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        return i;
      }
    }
    return -1;
  }
}