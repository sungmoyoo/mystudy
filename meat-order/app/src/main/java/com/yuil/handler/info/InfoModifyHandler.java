package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.handler.PrintType;
import com.yuil.vo.Info;

public class InfoModifyHandler extends AbstractMenuHandler {

  private InfoDao infoDao;
  PrintType c = new PrintType(prompt);
  public InfoModifyHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Info old = infoDao.findBy(no);
    if (old == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Info info = new Info();
    info.setProductNo(old.getProductNo()); // 기존 게시글의 번호를 그대로 설정한다.
    info.setClassification(c.getTypeChoice());
    info.setProductName(this.prompt.input("상품명(%s)? ", old.getProductName()));


    infoDao.update(info);
    System.out.println("게시글을 변경했습니다.");
  }
}
