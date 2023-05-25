package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class TaxableNightlyDiscountPhone extends NightlyDiscountPhone {
  private double taxRate;

  public TaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(nightlyAmount, regularAmount, seconds);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate)); //TaxableRegularPhone과 코드가 거의 동일하지만 자바는 단일 상속을 지원하기 때문에 상속으로 인해 발생하는 중복코드 문제 해결이 되지 않는다.
  }
}
