package com.yuil.vo;

import java.sql.Date;

public class Stock {

  private int stockNo;
  private int stock;
  private Date expirationDate;
  private int productNo;
  private String classification;
  private String productName;

  public int getStockNo() {
    return stockNo;
  }

  public void setStockNo(int stockNo) {
    this.stockNo = stockNo;
  }

  public int getProductNo() {
    return productNo;
  }

  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
