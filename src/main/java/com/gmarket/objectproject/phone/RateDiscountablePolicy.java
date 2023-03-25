package com.gmarket.objectproject.phone;

public class RateDiscountablePolicy extends AdditionalRatePolicy{

  private Money discountAmount;

  public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }

  /**
   * AdditionalRatePolicy의 자식 클래스는 부모클래스 몰래 next 값을 수정하는 것이 가능하다.
   * 자식 클래스가 계약을 위반할 수 있는 코드를 작성하는 것을 막을 수 있는 유일한 방법은 인스턴스 변수의 가시성을 protected가 아니라 private로 만드는 것 뿐이다.
   * 자식 클래스에서 인스턴스 변수의 상태를 변경하고 싶다면 부모클래스에 protected 메서드를 제공하고 이 메서드를 통해 불변식을 체크하게 해야한다.
   *
  public void changeNext(RatePolicy next){
    this.next = next;
  }
   */

}
