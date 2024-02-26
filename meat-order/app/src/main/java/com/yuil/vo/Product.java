package com.yuil.vo;

import java.sql.Date;
import java.util.List;

public class Product {

  private int no;
  private String name;
  private String describe;
  private int price;
  private int gram;
  private Date registerDate;
  private List<AttachedFile> files;
  private int category;

  @Override
  public String toString() {
    return "Product{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", describe='" + describe + '\'' +
        ", price=" + price +
        ", gram=" + gram +
        ", registerDate=" + registerDate +
        ", files=" + files +
        ", category=" + category +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getGram() {
    return gram;
  }

  public void setGram(int gram) {
    this.gram = gram;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public List<AttachedFile> getFiles() {
    return files;
  }

  public void setFiles(List<AttachedFile> files) {
    this.files = files;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }
}
