package com.gmarket.objectproject.defaultinterface;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmountDiscountPolicy implements DiscountPolicy{
  private Money discountAmount;
  private List<DiscountCondition> conditions = new ArrayList<>();

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    this.discountAmount = discountAmount;
    this.conditions = Arrays.asList(conditions);
  }

  /**
   * 인터페이스가 메서드 구현을 포함할 수는 있지만 인스턴스 변수를 포함할 수는 없기 때문에 해당 메서드가 존재해야한다.
   */
  @Override
  public List<DiscountCondition> getConditions() {
    return conditions;
  }

  /**
   * 인터페이스에 포함된 디폴트 메서드가 해당 메서드를 호출하기 때문에 public으로 구현되어야 한다.
   */
  @Override
  public Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }
}
