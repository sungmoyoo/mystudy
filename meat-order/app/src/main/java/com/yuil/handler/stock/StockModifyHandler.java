package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;
import com.yuil.handler.Choice;
import com.yuil.vo.Order;
import com.yuil.vo.Stock;

public class StockModifyHandler extends AbstractMenuHandler {

  private StockDao stockDao;
  Choice c = new Choice(prompt);
  public StockModifyHandler(StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Stock old = stockDao.findBy(no);
    if (old == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Stock stock = new Stock();
    stock.setNo(old.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    stock.setClassification(c.getTypeChoice());
    stock.setProduct(this.prompt.input("변경 제품(%s)? ", old.getProduct()));
    stock.setStock(this.prompt.inputInt("변경 수량(%s)? ", old.getStock()));
    stock.setExpirationDate(old.getExpirationDate());

    stockDao.update(stock);
    System.out.println("게시글을 변경했습니다.");
  }
}
