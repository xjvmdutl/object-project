package com.gmarket.objectproject.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

  private List<DiscountCondition> conditions = new ArrayList<>();

  public DiscountPolicy(DiscountCondition... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  /**
   * 암묵적인 계약 조건이 있었다.
   */
  public Money calculateDiscountAmount(Screening screening) {
    checkPrecondition(screening); //사전 조건 체크

    Money amount = Money.ZERO;
    for (DiscountCondition each : conditions) {
      if (each.isSatisfiedBy(screening)) {
        amount = getDiscountAmount(screening);
        checkPostcondition(amount); //사후 조건 체크
        return amount;
      }
    }
    amount = screening.getMovieFee();
    checkPostcondition(amount); //사후 조건 체크
    return amount;
  }

  protected void checkPrecondition(Screening screening) {
    assert screening != null && screening.getStartTime().isAfter(LocalDateTime.now());
  }

  protected void checkPostcondition(Money amount) {
    assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
  }

  abstract protected Money getDiscountAmount(Screening Screening);
}
