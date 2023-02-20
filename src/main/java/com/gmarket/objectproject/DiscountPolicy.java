package com.gmarket.objectproject;

public interface DiscountPolicy {
  Money calculateDiscountAmount(Screening screening);
}
