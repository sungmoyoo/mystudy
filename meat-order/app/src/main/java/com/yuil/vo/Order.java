package com.yuil.vo;

import java.util.Date;

public class Order {
  private int orderNo;
  private int stockNo;
  private String classification;
  private String product;
  private int count;
  private Date orderDate;

  public int getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }

  public int getStockNo() {
    return stockNo;
  }

  public void setStockNo(int stockNo) {
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

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
}
