package com.gmarket.objectproject.reservation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Movie {

  private String title;
  private Duration runningTime;
  private Money fee;
  private DiscountPolicy discountPolicy;

  public Movie(String title, Duration runningTime, Money fee) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    //this.discountPolicy = discountPolicy;
    this.discountPolicy = ServiceLocator.discountPolicy();
  }

  public Money getFee() {
    return fee;
  }

  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    this.discountPolicy = discountPolicy;
  }
  public Money calculateDiscountAmount(Screening screening, DiscountPolicy discountPolicy) {
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
  public Money calculateMovieFee(Screening screening) {
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
}
