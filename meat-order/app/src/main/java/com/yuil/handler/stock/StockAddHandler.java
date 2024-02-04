package com.yuil.handler.stock;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.dao.StockDao;
import com.yuil.vo.Info;
import com.yuil.vo.Stock;
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

    List<Info> list = infoDao.findAll();
    List<Stock> checkList = stockDao.findAll();
    Stock stock = new Stock();

    try {
      for (Info info : list) {
        System.out.printf("[%d] %s\n", info.getProductNo(), info.getProductName());
      }

      stock.setProductNo(prompt.inputInt("입고하실 상품번호: "));
      stock.setStock(prompt.inputInt("입고 수량: "));
      stock.setExpirationDate(prompt.inputDate("유통기한: "));

      int existNo = DateValidator.isExist(checkList, stock);
      if (existNo != -1) {
        stock.setProductNo(checkList.get(existNo).getProductNo());
        stock.setStockNo(checkList.get(existNo).getStockNo());
        stock.setStock(checkList.get(existNo).getStock() + stock.getStock());
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
