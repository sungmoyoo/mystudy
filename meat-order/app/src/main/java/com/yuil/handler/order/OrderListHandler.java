package com.yuil.handler.order;

import com.util.Prompt;
import com.menu.AbstractMenuHandler;
import com.yuil.dao.OrderDao;
import com.yuil.vo.Order;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderListHandler extends AbstractMenuHandler {

  private OrderDao orderDao;

  public OrderListHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%-4s\t%s\n", "주문번호", "종류", "제품", "중량", "주문날짜");

    List<Order> list = orderDao.findAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Order order : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%-4d\t%s\n",
          order.getNo(),
          order.getClassification(),
          order.getProduct(),
          order.getGram(),
          dateFormat.format(order.getOrderDate()));
    }
  }
}
