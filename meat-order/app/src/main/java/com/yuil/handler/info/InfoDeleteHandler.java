package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;

public class InfoDeleteHandler extends AbstractMenuHandler {

  private InfoDao infoDao;

  public InfoDeleteHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (infoDao.delete(no) == 0) {
      System.out.println("주문 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
