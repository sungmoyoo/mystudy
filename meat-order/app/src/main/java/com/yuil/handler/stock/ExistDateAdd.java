package com.yuil.handler.stock;

import com.yuil.vo.Stock;
import java.util.List;

public class ExistDateAdd {
  public static boolean isExist(List<Stock> checkList, Stock stock) {

    for (Stock valid : checkList) {
      if (valid.getExpirationDate() != null
          && valid.getExpirationDate().equals(stock.getExpirationDate())
          && valid.getProductNo() == stock.getProductNo()) {

        stock.setProductNo(valid.getProductNo());
        stock.setStockNo(valid.getStockNo());
        stock.setStock(valid.getStock() + stock.getStock());
        return true;
      }
    }
    return false;
  }
}
