package com.gmarket.objectproject.reservation.pricing;

import com.gmarket.objectproject.reservation.DiscountPolicy;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
  @Override
  protected Money getDiscountAmount(Screening screening) {
    return Money.ZERO;
  }
}
