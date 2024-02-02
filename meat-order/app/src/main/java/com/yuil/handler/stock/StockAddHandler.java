package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.handler.Choice;
import com.yuil.vo.Stock;

public class StockAddHandler extends AbstractMenuHandler {

  private StockDao stockDao;
  Choice c = new Choice(prompt);

  public StockAddHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    Stock stock = new Stock();
    stock.setClassification(c.getTypeChoice());
    stock.setProduct(prompt.input("제품(부위): "));
    stock.setStock(prompt.inputInt("재고수: "));
    stock.setExpirationDate(prompt.inputDate("유통기한: "));

    stockDao.add(stock);
  }


}
