package com.gmarket.objectproject.covariance;

public class Customer {
  private Book book;

  public void order(BookStall bookStall){
    this.book = bookStall.sell(new IndependentPublisher());
  }
}
