package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.StockDao;
import com.yuil.vo.Stock;
import java.util.List;

public class StockModifyHandler extends AbstractMenuHandler {

  private StockDao stockDao;
  public StockModifyHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    List<Stock> checkList = stockDao.findAll();
    Stock old = stockDao.findBy(this.prompt.inputInt("변경하실 재고번호? "));
    Stock stock = new Stock();

    if (old == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    stock.setProductNo(old.getProductNo());
    stock.setStock(prompt.inputInt("변경 수량(%s)? ", old.getStock()));
    stock.setExpirationDate(prompt.inputDate("변경할 유통기한(%s)? ", old.getExpirationDate()));

    int existNo = DateValidator.isExist(checkList, stock);
    if (existNo != -1) {
      stockDao.update(stock);
    } else {
      stockDao.delete(old.getStockNo());
      stockDao.add(stock);
    }

    System.out.println("게시글을 변경했습니다.");
  }
}
