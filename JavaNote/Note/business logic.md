1. 재고테이블 + 주문테이블
2. 상품 정보 테이블 추가 후 1대 다 연결 왜 why? 중복 값이 있으니까 그리도 비즈니스 로직을 위해
3. 비즈니스 로직 
  - 재고 등록 시 유통기한+상품번호가 같은 제품이 있다면 업데이트 없다면 새로 추가

  문제 발생! 
  기존 재고리스트를 데이터베이스에서 가져와 전체 순회하여 유통기한+상품번호가 같은 경우에 update 처리하려 했는데 조건에 일치하는 값을 찾지 못하고 계속 add가 되어버린다.
  ```java
    List<Info> list = infoDao.findAll();
    List<Stock> checker = stockDao.findAll();
    Stock stock = new Stock();
    boolean isExist = false;
    try {
      for (Info info : list) {
        System.out.printf("[%d] %s\n", info.getProductNo(), info.getProductName());
      }

      stock.setProductNo(prompt.inputInt("입고하실 상품번호: "));
      stock.setStock(prompt.inputInt("입고 수량: "));
      stock.setExpirationDate(prompt.inputDate("유통기한: "));

      for (Stock s : checker) {
        if (s.getExpirationDate().equals(stock.getExpirationDate()) && s.getProductNo() == stock.getProductNo()) {
          stock.setStockNo(s.getStockNo());
          stock.setStock(s.getStock() + stock.getStock());
          isExist = true;
        }
      }
      if (isExist) {
        stockDao.update(stock);
      } else {
        stockDao.add(stock);
      }

    } catch (Exception e) {
      System.out.println("재고 입고 중 오류 발생");
      e.printStackTrace();
    }
  }
  ```
  문제는 앞서 DAO findAll 메서드에서 찾을 수 있었다. 
  findAll은 데이터베이스에서 select/join으로 리턴한 새 가상 테이블에 product_no 컬럼을 추가하지 않아 전부 0이었기 때문에 일치하는 값을 찾을 수 없던 것이었다..

  - 주문 등록 시 해당 수량 만큼 재고 차감, 만약 재고가 없다면 품절 출력
  - 가격? 추가할지 말지 모름

