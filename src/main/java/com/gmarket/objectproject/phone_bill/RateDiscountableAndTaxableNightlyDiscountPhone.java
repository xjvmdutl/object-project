package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class RateDiscountableAndTaxableNightlyDiscountPhone extends RateDiscountableNightlyDiscountPhone {

  private double taxRate;

  public RateDiscountableAndTaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount, double taxRate) {
    super(nightlyAmount, regularAmount, seconds,discountAmount);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return super.afterCalculated(fee).plus(fee.times(taxRate)); //새로운 정책을 추가하기 위해서는 불필요하게 많은 수의 클래스를 상속 계층 안에 추가해야 한다.
  }
}
