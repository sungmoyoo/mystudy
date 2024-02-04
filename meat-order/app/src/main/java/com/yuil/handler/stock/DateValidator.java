package com.yuil.handler.stock;

import com.yuil.vo.Stock;
import java.util.List;

public class DateValidator {
  protected static int isExist(List<Stock> checkList, Stock stock) {

    for (Stock valid : checkList) {
      if (valid.getExpirationDate() != null
          && valid.getExpirationDate().equals(stock.getExpirationDate())
          && valid.getProductNo() == stock.getProductNo()) {

        return valid.getStockNo();
      }
    }
    return -1;
  }
}
