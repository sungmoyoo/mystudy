package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.dao.StockDao;
import com.yuil.vo.Member;
import com.yuil.vo.Product;
import java.util.List;

public class StockAddHandler extends AbstractMenuHandler {


  private InfoDao infoDao;
  private StockDao stockDao;

  public StockAddHandler(StockDao stockDao, InfoDao infoDao, Prompt prompt) {
    super(prompt);
    this.infoDao = infoDao;
    this.stockDao = stockDao;
  }

  @Override
  protected void action() {

    List<Member> list = infoDao.findAll();
    List<Product> checkList = stockDao.findAll();
    Product stock = new Product();

    try {
      for (Member info : list) {
        System.out.printf("[%d] %s\n", info.getProductNo(), info.getProductName());
      }

      stock.setProductNo(prompt.inputInt("입고하실 상품번호: "));
      stock.setStock(prompt.inputInt("입고 수량: "));
      stock.setExpirationDate(prompt.inputDate("유통기한: "));


      if (ExistDateAdd.isExist(checkList, stock)) {
        stockDao.update(stock);
      } else {
        stockDao.add(stock);
      }

    } catch (Exception e) {
      System.out.println("재고 입고 중 오류 발생");
      e.printStackTrace();
    }
  }



}
