package com.gmarket.objectproject;

public class NoneDefaultDiscountPolicy extends DiscountPolicy {
  @Override
  protected Money getDiscountAmount(Screening screening) {
    return Money.ZERO;
  }
}
