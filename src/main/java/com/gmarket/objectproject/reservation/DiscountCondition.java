package com.gmarket.objectproject.reservation;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DiscountCondition {
  public boolean isSatisfiedBy(Screening screening);
}
