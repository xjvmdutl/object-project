package com.gmarket.objectproject.covariance;

public class BookStall {

  public Book sell(IndependentPublisher independentPublisher){
    return new Book(independentPublisher);
  }
}
