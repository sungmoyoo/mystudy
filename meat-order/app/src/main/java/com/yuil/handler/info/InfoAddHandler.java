package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.handler.PrintType;
import com.yuil.vo.Info;

public class InfoAddHandler extends AbstractMenuHandler {

  private InfoDao infoDao;
  PrintType pt = new PrintType(prompt);

  public InfoAddHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    Info info = new Info();
    info.setClassification(pt.getTypeChoice());
    info.setProductName(prompt.input("상품(부위): "));


    infoDao.add(info);
  }


}
