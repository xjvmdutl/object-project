package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone {

  private Money amount;
  private Duration seconds;

  private double taxRate;

  public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
    super(amount, seconds);
    this.taxRate = taxRate;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    Money fee = super.calculateFee(); //일반 계산제 요금을 계산
    //super 호출을 통해 메서드 재사용이 가능하지만 부모와 자식 사이의 결합도가 높아졌다 -> 결합도를 낮추기 위해 자식클래스가 부모 클래스의 메서드를 호출하지 않도록 부모 클래스에 추상 메서드를 제공
    //부모 클래스가 자신이 정의한 추상 메서드를 호출하고 자식 클래스가 이 메서드를 오버라이딩해서 부모 클래스가 원하는 로직을 제공하도록 수정하면 부모 클래스와 자식 클래스 사이의 결합도를 느슨하게 만들 수 있다
    return fee.plus(fee.times(taxRate)); //반환된 일반 계산제 요금에 세금 부과
  }

  //세금을 부과하도록 코드 추가
  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
  }
}
