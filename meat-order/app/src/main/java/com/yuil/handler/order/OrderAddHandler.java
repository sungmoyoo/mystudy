package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;
import com.yuil.vo.Member;
import com.yuil.vo.User;
import com.yuil.vo.Product;
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
    User order = new User();
    List<Product> stockList = stockDao.findAll();
    List<Member> infoList = infoDao.findJoin();
    int i = 1;
    for (Member info : infoList) {
      System.out.printf("%d. %s (남은 재고: %d)\n", i++, info.getProductName(), info.getStock());
    }

    order.setProductName(prompt.input("구매하실 상품명을 입력하세요: "));
    order.setCount(prompt.inputInt("수량: "));
    order.setOrderDate(new Date());

    boolean foundMatch = false;

    for (Member info : infoList) {
      if (order.getProductName().equals(info.getProductName())) {
        foundMatch = true;
      }
    }

    if (foundMatch) {
      if (SoldOutValidator.isOut(stockList, order, stockDao)) {
        orderDao.add(order);
        System.out.println("주문이 완료되었습니다.");

      } else {
        System.out.println("주문가능한 상품을 초과 또는 품절되었습니다.");

      }
    } else {
      System.out.println("올바르지 않은 상품명입니다.");

    }
  }
}
