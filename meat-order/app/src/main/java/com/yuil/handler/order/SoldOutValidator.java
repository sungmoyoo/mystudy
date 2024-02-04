package com.yuil.handler.order;

import com.yuil.dao.StockDao;
import com.yuil.vo.Order;
import com.yuil.vo.Stock;
import java.util.List;

public class SoldOutValidator {
  protected static boolean isOut(List<Stock> stockList, Order order, StockDao stockDao) {
    for (Stock stock : stockList) {
      if (stock.getProductName().equals(order.getProductName())) {
        order.setStockNo(stock.getStockNo());
        order.setExpirationDate(stock.getExpirationDate());
        if (stock.getStock() - order.getCount() < 0 ) {
          return false;

        } else if(stock.getStock() - order.getCount() == 0) {
          stock.setStock(stock.getStock() - order.getCount());
          stockDao.delete(order.getStockNo());
          return true;

        } else if (stock.getStock() - order.getCount() > 0){
          stock.setStock(stock.getStock() - order.getCount());
          stockDao.update(stock);
          return true;

        }
      }
    }
    return false;
  }
}
