package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.handler.PrintType;
import com.yuil.vo.Member;

public class InfoAddHandler extends AbstractMenuHandler {

  private InfoDao infoDao;
  PrintType pt = new PrintType(prompt);

  public InfoAddHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    Member info = new Member();
    info.setClassification(pt.getTypeChoice());
    info.setProductName(prompt.input("상품(부위): "));


    infoDao.add(info);
  }


}
