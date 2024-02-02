package com.yuil.handler.stock;

import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.vo.Stock;
import java.text.SimpleDateFormat;
import java.util.List;

public class StockListHandler extends AbstractMenuHandler {

  private StockDao stockDao;

  public StockListHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-10s  %-20s  %-15s  %-6s  %s\n", "재고번호", "종류", "제품", "수량", "유통기한");

    List<Stock> list = stockDao.findAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Stock stock : list) {
      System.out.printf("%-10d  %-20s  %-15s  %-6d  %s\n",
          stock.getNo(),
          stock.getClassification(),
          stock.getProduct(),
          stock.getStock(),
          dateFormat.format(stock.getExpirationDate()));
    }
  }
}
