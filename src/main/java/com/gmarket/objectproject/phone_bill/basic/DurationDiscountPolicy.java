package com.gmarket.objectproject.phone_bill.basic;

import com.gmarket.objectproject.phone_bill.BasicRatePolicy;
import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.Money;
import java.util.ArrayList;
import java.util.List;

/**
 * DurationDiscountPolicy 클래스는 할인 요금을 정상적으로 계산하고 각 클래스는 하나의 책임만을 수행한다. -> 이 설계는 좋은 설계가 아닌데 이유는 기본 정책을 구현하는 기존 클래스들과 일관성이 없기 때문이다.
 * 기존의 설계가 어떤 가이드도 제공하지 않기 때문에 새로운 기본 정책을 구현해야 하는 상화에서 또 다른 개발자는 다른 방식으로 기본 정책을 구현할 확률이 높고, 시간이 흐를수록 설계의 일관성은 더욱 어긋나게 될 것이다.
 *
 */
public class DurationDiscountPolicy extends BasicRatePolicy {

  private List<DurationDiscountRule> rules = new ArrayList<>();

  public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
    this.rules = rules;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    Money result = Money.ZERO;
    for(DurationDiscountRule rule: rules){
      result.plus(rule.calculate(call));
    }
    return result;
  }
}
