package com.gmarket.objectproject.reservation.pricing;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.DiscountPolicy;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
  private double percent;

  public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}
