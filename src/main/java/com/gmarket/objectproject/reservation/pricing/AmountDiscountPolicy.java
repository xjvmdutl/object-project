package com.gmarket.objectproject.reservation.pricing;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.DiscountPolicy;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
  private Money discountAmount;

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    super(conditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }


}
