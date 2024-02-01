package com.yuil.vo;

import java.util.Date;

public class Order {
  private int orderNo;
  private String classification;
  private String product;
  private int gram;
  private Date orderDate;


  public int getNo() {
    return orderNo;
  }

  public void setNo(int orderNo) {
    this.orderNo = orderNo;
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

  public int getGram() {
    return gram;
  }

  public void setGram(int count) {
    this.gram = count;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
}
