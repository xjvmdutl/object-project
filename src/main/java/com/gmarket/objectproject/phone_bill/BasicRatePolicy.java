package com.gmarket.objectproject.phone_bill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 변하지 않는 요소와 추상적인 요소만으로도 요금 계산에 필요한 전체적인 협력 구조를 설명할 수 있다.
 * 변하는 것과 변하지 않는 것을 분리하고변하는 것을 캡슐화한 코드는 오로지 변하지 않는 것과 추상화에 대한 의존성만으로도 전체적인 협력을 구현할 수 있다.
 * 변하는 것은 추상화 뒤에 캡슐화되어 숨겨져 있기 때문에 전체적인 협력의 구조에 영향을 미치지 않는다.
 */
public abstract class BasicRatePolicy implements RatePolicy{
  private List<FeeRule> feeRules = new ArrayList<>();

  public BasicRatePolicy(FeeRule... feeRules) {
    this.feeRules = Arrays.asList(feeRules);
  }

  @Override
  public Money calculateFee(Phone phone) {
    return phone.getCalls()
        .stream().map(call -> calculate(call))
        .reduce(Money.ZERO, (first, second) -> first.plus(second));
  }

  private Money calculate(Call call) {
    return feeRules.stream()
        .map(rule -> rule.calculateFee(call))
        .reduce(Money.ZERO, (first, second) -> first.plus(second));
  }

}
