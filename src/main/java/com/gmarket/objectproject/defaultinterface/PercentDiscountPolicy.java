package com.gmarket.objectproject.defaultinterface;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentDiscountPolicy implements DiscountPolicy{
  private double percent;
  private List<DiscountCondition> conditions = new ArrayList<>();

  public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
    this.percent = percent;
    this.conditions = Arrays.asList(conditions);
  }

  @Override
  public List<DiscountCondition> getConditions() {
    return conditions;
  }

  @Override
  public Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}
