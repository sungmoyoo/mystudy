package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;
import com.yuil.vo.Info;
import com.yuil.vo.Order;
import com.yuil.vo.Stock;
import java.util.Date;
import java.util.List;

public class OrderAddHandler extends AbstractMenuHandler {

  private OrderDao orderDao;
  private StockDao stockDao;
  private InfoDao infoDao;

  public OrderAddHandler(OrderDao orderDao, StockDao stockDao, InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
    this.stockDao = stockDao;
    this.infoDao = infoDao;
  }

  @Override
  protected void action() {
    Order order = new Order();
    List<Stock> stockList = stockDao.findAll();
    List<Info> infoList = infoDao.findAll();
    for (Info info : infoList) {
      if ()
      System.out.printf("%d. %s (남은 재고: %d)", info.getProductNo(), info.getProductName(), );
    }
    order.setProductName(prompt.input("구매하실 상품명을 입력하세요: "));
    order.setCount(prompt.inputInt("수량: "));
    order.setOrderDate(new Date());

    if (SoldOutValidator.isOut(stockList, order, stockDao)) {
      orderDao.add(order);
      System.out.println("주문이 완료되었습니다.");
    } else {
      orderDao.delete(order.getStockNo());
      System.out.println("주문하신 상품이 품절되었습니다.");
    }



  }


}
