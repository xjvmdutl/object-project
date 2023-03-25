package com.gmarket.objectproject.covariance;

public class MagazineStore extends BookStall{

  @Override
  public Book sell(IndependentPublisher independentPublisher) {
    return new Magazine(independentPublisher);
  }
}
