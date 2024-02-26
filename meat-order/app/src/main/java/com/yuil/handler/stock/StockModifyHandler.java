package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.vo.Product;

public class StockModifyHandler extends AbstractMenuHandler {

  private StockDao stockDao;
  public StockModifyHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    Product old = stockDao.findBy(this.prompt.inputInt("변경하실 재고번호? "));
    Product stock = new Product();

    if (old == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    stock.setStockNo(old.getStockNo());
    stock.setProductNo(old.getProductNo());
    stock.setStock(prompt.inputInt("변경 수량(%s)? ", old.getStock()));
    stock.setExpirationDate(prompt.inputDate("변경할 유통기한(%s)? ", old.getExpirationDate()));

    stockDao.update(stock);


    System.out.println("게시글을 변경했습니다.");
  }
}
