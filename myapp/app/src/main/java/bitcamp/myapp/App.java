package bitcamp.myapp;

import bitcamp.myapp.menu.BoardAddHandler;
import bitcamp.myapp.menu.MenuGroup;
import bitcamp.myapp.menu.MenuItem;
import bitcamp.util.Prompt;

public class App {
  
  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
//    new MainMenu(prompt).execute();
    MenuGroup mainMenu = new MenuGroup("메인");
    
    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(prompt)));
    boardMenu.add(new MenuItem("조회"));
    boardMenu.add(new MenuItem("변경"));
    boardMenu.add(new MenuItem("삭제"));
    boardMenu.add(new MenuItem("목록"));
    
    mainMenu.add(boardMenu);
    
    mainMenu.execute(prompt);
    
    prompt.close();
  }
}
