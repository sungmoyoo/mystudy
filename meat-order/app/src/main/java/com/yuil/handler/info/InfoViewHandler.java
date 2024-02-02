package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.vo.Info;

public class InfoViewHandler extends AbstractMenuHandler {

  private InfoDao infoDao;

  public InfoViewHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Info info = infoDao.findBy(no);
    if (info == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("상품번호: %d\n", info.getProductNo());
    System.out.printf("종류: %s\n", info.getClassification());
    System.out.printf("상품명: %s\n", info.getProductName());

  }
}
