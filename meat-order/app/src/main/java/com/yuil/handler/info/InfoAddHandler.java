package com.yuil.handler.info;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.handler.Choice;
import com.yuil.vo.Info;

public class InfoAddHandler extends AbstractMenuHandler {

  private InfoDao infoDao;
  Choice c = new Choice(prompt);

  public InfoAddHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    Info info = new Info();
    info.setClassification(c.getTypeChoice());
    info.setProductName(prompt.input("제품(부위): "));


    infoDao.add(info);
  }


}
