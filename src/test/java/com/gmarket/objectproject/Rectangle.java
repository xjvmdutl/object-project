package com.gmarket.objectproject;

public class Rectangle {
  private int left;
  private int top;
  private int right;
  private int bottom;

  /**
   * 캡슐화를 통해 자신의 크기를 rectangle이 증가시키도록 책임을 이동시켰다
   */
  public void enlarge(int multiple){
    right *= multiple;
    bottom *= multiple;
  }
  /*

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public int getTop() {
    return top;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public int getRight() {
    return right;
  }

  public void setRight(int right) {
    this.right = right;
  }

  public int getBottom() {
    return bottom;
  }

  public void setBottom(int bottom) {
    this.bottom = bottom;
  }*/
}
