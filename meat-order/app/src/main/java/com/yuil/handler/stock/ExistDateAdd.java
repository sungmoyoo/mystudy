package com.yuil.handler.stock;

import com.yuil.vo.Product;
import java.util.List;

public class ExistDateAdd {
  public static boolean isExist(List<Product> checkList, Product stock) {

    for (Product valid : checkList) {
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
