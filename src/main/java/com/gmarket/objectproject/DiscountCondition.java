package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public boolean isDiscountable(DiscountCondition condition, Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
      return isSatisfiedByPeriod(condition, screening);
    }
    return isSatisfiedBySequence(condition, screening);
  }

  private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
    return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek)
        && startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
        && endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
  }

  private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
    return sequence == screening.getSequence();
  }
}
