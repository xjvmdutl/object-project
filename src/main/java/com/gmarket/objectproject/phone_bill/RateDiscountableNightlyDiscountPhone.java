package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {

  private Money discountAmount;

  public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount) {
    super(nightlyAmount, regularAmount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount); //RateDiscountableRegularPhone 사이 코드 중복을 야기한다.
  }
}
