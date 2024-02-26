package com.yuil.handler.order;

import com.yuil.dao.StockDao;
import com.yuil.vo.User;
import com.yuil.vo.Product;
import java.util.List;

public class SoldOutValidator {
  protected static boolean isOut(List<Product> stockList, User order, StockDao stockDao) {
    for (Product stock : stockList) {
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
