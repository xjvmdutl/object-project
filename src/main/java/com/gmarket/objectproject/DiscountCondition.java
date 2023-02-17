package com.gmarket.objectproject;

/**
 * SequenceCondition, PeriodCondition 클래스로 두가지 할인 조건을 구현
 */
public interface DiscountCondition {
  boolean isSatisfiedBy(Screening screening);
}
