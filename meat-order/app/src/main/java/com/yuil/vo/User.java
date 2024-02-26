package com.yuil.vo;

public class User {
  private int memberNo;
  private String nickname;
  private int postNo;
  private String defaultAddress;
  private String detailAddress;

  @Override
  public String toString() {
    return "User{" +
        "memberNo=" + memberNo +
        ", nickname='" + nickname + '\'' +
        ", postNo=" + postNo +
        ", defaultAddress='" + defaultAddress + '\'' +
        ", detailAddress='" + detailAddress + '\'' +
        '}';
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getPostNo() {
    return postNo;
  }

  public void setPostNo(int postNo) {
    this.postNo = postNo;
  }

  public String getDefaultAddress() {
    return defaultAddress;
  }

  public void setDefaultAddress(String defaultAddress) {
    this.defaultAddress = defaultAddress;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
}
