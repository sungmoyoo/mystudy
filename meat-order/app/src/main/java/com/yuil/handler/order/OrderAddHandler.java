package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.menu.MenuGroup;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.vo.Order;
import java.util.Date;

public class OrderAddHandler extends AbstractMenuHandler {

  private OrderDao orderDao;
  Choice c = new Choice(prompt);

  public OrderAddHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    Order order = new Order();
    order.setClassification(c.getTypeChoice());
    order.setProduct(prompt.input("제품(부위)?"));
    order.setGram(prompt.inputInt("중량?"));
    order.setOrderDate(new Date());

    orderDao.add(order);
  }


}
