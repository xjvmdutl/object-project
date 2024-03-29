package com.gmarket.objectproject.phone_bill.additional;

import com.gmarket.objectproject.phone_bill.AdditionalRatePolicy;
import com.gmarket.objectproject.phone_bill.Money;
import com.gmarket.objectproject.phone_bill.RatePolicy;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

  private Money discountAmount;

  public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}
