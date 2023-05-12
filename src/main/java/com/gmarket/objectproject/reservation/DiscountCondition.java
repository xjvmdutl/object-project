package com.gmarket.objectproject.reservation;


public interface DiscountCondition {
  public boolean isSatisfiedBy(Screening screening);
}
