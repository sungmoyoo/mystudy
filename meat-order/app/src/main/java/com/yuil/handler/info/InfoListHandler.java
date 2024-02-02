package com.yuil.handler.info;

import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.vo.Info;
import java.text.SimpleDateFormat;
import java.util.List;

public class InfoListHandler extends AbstractMenuHandler {

  private InfoDao infoDao;

  public InfoListHandler(InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-10s  %-20s  %-15s\n", "제품번호", "종류", "제품");

    List<Info> list = infoDao.findAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Info info : list) {
      System.out.printf("%-10d  %-20s  %-15s\n",
          info.getProductNo(),
          info.getClassification(),
          info.getProductName());
    }
  }
}
