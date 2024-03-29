package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.vo.Product;

public class StockViewHandler extends AbstractMenuHandler {

  private StockDao stockDao;

  public StockViewHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Product stock = stockDao.findBy(no);
    if (stock == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("재고번호: %d\n", stock.getStockNo());
    System.out.printf("종류: %s\n", stock.getClassification());
    System.out.printf("상품명: %s\n", stock.getProductName());
    System.out.printf("수량: %s\n", stock.getStock());
    System.out.printf("유통기한: %1$tY-%1$tm-%1$td\n", stock.getExpirationDate());
  }
}
