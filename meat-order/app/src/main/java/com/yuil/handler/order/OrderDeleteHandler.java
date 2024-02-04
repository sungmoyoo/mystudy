package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;
import com.yuil.handler.stock.ExistDateAdd;
import com.yuil.vo.Order;
import com.yuil.vo.Stock;
import java.util.List;

public class OrderDeleteHandler extends AbstractMenuHandler {

  private OrderDao orderDao;
  private StockDao stockDao;

  public OrderDeleteHandler(OrderDao orderDao,StockDao stockDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("주문 번호? ");

    Order old = orderDao.findBy(no);
    List<Stock> checkList = stockDao.findAll();

    if (old == null) {
      System.out.println("주문번호가 유효하지 않습니다.");
    } else {
      Stock stock = new Stock();

      stock.setProductNo(old.getProductNo());
      stock.setStock(old.getStock());
      stock.setExpirationDate(old.getExpirationDate());

      if (ExistDateAdd.isExist(checkList, stock)) {
        stockDao.update(stock);
      } else {
        stockDao.add(stock);
      }

      orderDao.delete(no);
    }
  }
}
