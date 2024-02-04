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
    System.out.printf("%-10s %-10s %-15s %-6s %s\n", "주문번호", "종류", "상품명", "수량", "주문일");

    List<Order> list = orderDao.findAll();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Order order : list) {
      System.out.printf("%-10d %-10s %-15s %-6d %s\n",
          order.getOrderNo(),
          order.getClassification(),
          order.getProductName(),
          order.getCount(),
          dateFormat.format(order.getOrderDate()));
    }
  }
}
