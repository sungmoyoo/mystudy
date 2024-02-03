package com.yuil.handler.order;

import com.yuil.dao.StockDao;
import com.yuil.vo.Order;
import com.yuil.vo.Stock;
import java.util.List;

public class SoldOutValidator {
  protected static boolean isOut(List<Stock> stockList, Order order, StockDao stockDao) {
    for (Stock stock : stockList) {
      if (stock.getProductName().equals(order.getProductName())) {
        if (stock.getStock() - order.getCount() < 0) {
          stockDao.delete(order.getStockNo());
          return false;
        } else {
          stock.setStock(stock.getStock() - order.getCount());
          stockDao.update(stock);

        }
      }
    }
    return true;
  }
}
