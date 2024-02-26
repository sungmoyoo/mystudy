package com.yuil.vo;

import java.sql.Date;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private String phone;
  private Date createdDate;

  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", phone='" + phone + '\'' +
        ", createdDate=" + createdDate +
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
