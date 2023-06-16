package com.gmarket.objectproject.phone_bill.basic;

import com.gmarket.objectproject.phone_bill.BasicRatePolicy;
import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.DateTimeInterval;
import com.gmarket.objectproject.phone_bill.Money;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {

  private List<DayOfWeekDiscountRule> rules = new ArrayList<>();

  public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
    this.rules = rules;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    Money result = Money.ZERO;
    for (DateTimeInterval interval : call.getInterval().splitByDay()) {
      for (DayOfWeekDiscountRule rule : rules) {
        result.plus(rule.calculate(interval));
      }
    }
    return result;
  }
}
