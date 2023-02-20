package com.gmarket.objectproject;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {
  /*
  @Override
  protected Money getDiscountAmount(Screening screening) {
    *//**
     * 해당 메서드가 어떤 값을 반환하더라도 상관 없다.
     * 부모 클래스인 DiscountPolicy가 할인 조건이 없을 경우 getDiscountAmount 메서드를 호출하지 않기 때문이다 -> 부모클래스인 DiscountPolicy 와 NoneDiscountPolicy를 개념적으로 결합시킨다.
     * 이 문제를 해결하기 위해서는 DiscountPolicy를 인터페이스로 바꾸고 NoneDiscountPolicy가 DiscountPolicy의 getDiscountAmount 메서드가 아닌 calculateDiscountAmount 오퍼레이션을 오버라이딩 하도록 변겨하는 것이다.
     *//*
    return Money.ZERO;
  }*/
  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return Money.ZERO;
  }

}
