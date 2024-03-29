package com.yuil.handler.stock;

import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.vo.Product;
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
    System.out.printf("%-10s  %-20s  %-15s  %-6s  %s\n", "재고번호", "종류", "상품", "수량", "유통기한");

    List<Product> list = stockDao.findAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Product stock : list) {
      System.out.printf("%-10d  %-20s  %-15s  %-6d  %s\n",
          stock.getStockNo(),
          stock.getClassification(),
          stock.getProductName(),
          stock.getStock(),
          dateFormat.format(stock.getExpirationDate()));
    }
  }
}
