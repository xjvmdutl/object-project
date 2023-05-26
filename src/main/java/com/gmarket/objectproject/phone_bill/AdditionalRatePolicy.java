package com.gmarket.objectproject.phone_bill;

public abstract class AdditionalRatePolicy implements RatePolicy{
  private RatePolicy next;

  public AdditionalRatePolicy(RatePolicy next) {
    this.next = next;//컴파일 타임 의존성을 런타임 의존성으로 쉽게 대체할 수 있도록 RatePolicy 타입의 인스턴스를 인자로 받는 생성자를 제공
  }

  @Override
  public Money calculateFee(Phone phone) {
    Money fee = next.calculateFee(phone);
    return afterCalculated(fee);
  }

  abstract protected Money afterCalculated(Money fee);
}
