package com.yuil.vo;

import java.sql.Date;

public class Stock {

  private int stockNo;
  private String classification;
  private String product;
  private int stock;
  private Date expirationDate;


  public int getNo() {
    return stockNo;
  }

  public void setNo(int stockNo) {
    this.stockNo = stockNo;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
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
