package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {
  private Money discountAmount;
  public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
    super(amount, seconds, taxRate);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return super.afterCalculated(fee).minus(discountAmount); //세금 부과 후, 기본 요금 할인을 적용하는 순서로 정책을 조합할 수 있다.
  }
}
