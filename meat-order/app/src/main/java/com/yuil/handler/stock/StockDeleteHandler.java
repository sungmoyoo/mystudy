package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;

public class StockDeleteHandler extends AbstractMenuHandler {

  private StockDao stockDao;

  public StockDeleteHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (stockDao.delete(no) == 0) {
      System.out.println("재고 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
