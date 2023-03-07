package com.gmarket.objectproject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Movie {

  private String title;
  private Duration runningTime;
  private Money fee;

  /*
  private List<PeriodCondition> periodConditions;
  private List<SequenceCondition> sequenceConditions;
   */
  //Movie - DiscountCondition 사이의 협력이 다형적으로 변경되었다
  /**
   * 다형성 패턴: 객체의 타입을 검사해서 타입에 따라 여러 대안들을 수행하는 조건적인 논리를 사용하지 말고, 다형성을 이용해 새로운 변화를 다루기 쉽게 확장하는 패턴이다.
   */
  private List<DiscountCondition> discountConditions;

  public Movie(String title, Duration runningTime, Money fee,
      DiscountCondition... discountConditions) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountConditions = Arrays.asList(discountConditions);
  }
  /*
  private Money calculateDiscountAmount() {
    switch (movieType){
      case AMOUNT_DISCOUNT:
        return calculateAmountDiscountAmount();
      case PERCENT_DISCOUNT:
        return calculatePercentDiscountAmount();
      case NONE_DISCOUNT:
        return calculateNoneDiscountAmount();
    }
    throw new IllegalArgumentException();
  }

  private Money calculateNoneDiscountAmount() {
    return discountAmount;
  }

  private Money calculatePercentDiscountAmount() {
    return fee.times(discountPercent);
  }

  private Money calculateAmountDiscountAmount() {
    return Money.ZERO;
  }
   */

  public Money calculateMovieFee(Screening screening) {
    if(isDiscountable(screening)){
      return fee.minus(calculateDiscountAmount());
    }
    return fee;
  }
  private boolean isDiscountable(Screening screening){
    return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
  }
  abstract protected Money calculateDiscountAmount();

  protected Money getFee(){ //해당 메서드는 서브클래스에서만 사용해야 하므로 가시성을 public이 아닌 protected로 제한해야 한다.
    return fee;
  }

  /*
  private boolean isDiscountable(Screening screening) {
    return checkPeriodConditions(screening) || checkSequenceConditions(screening);
  }

   */
  /**
   * 1) 설계를 분리한 이후로는 전체적인 결합도가 높아졌다
   * periodCondition, sequenceCondition 클래스 양쪽 모두에게 결합된다.
   * 2) 새로운 할인 조건을 추가하기가 더 어려워졌다.
   * DiscountCondition 입장에서는 응집도가 높아졌지만, 변경과 캡슐화라는 관점에서 보면 전체적으로 설계의 품질이 나빠졌다
   *
   * Movie의 입장에서는 periodCondition, sequenceCondition 모두 동일한 책임을 수행하므로 동일한 역할을 수행한다는 것을 의미한다.
   * 역할은 협력안에서 대체 가능성을 의미하기 때문에 periodCondition, sequenceCondition에 역할의 개념을 적용하면 Movie가 구체적인 클래스는 알지 못한 채 오직 역할에 대해서만 결합되도록 의존성을 제한할 수 있다.
   * 역할을 대체할 클래스들 사이에서 구현을 공유해야 할 필요가 있다면 추상클래스를 이용하고 공유할 필요 없이 역할을 대체하는 객체들의 책임만 정의하고 싶다면 인터페이스를 사용하면 된다.
   *
   */
  /*
  private boolean checkPeriodConditions(Screening screening) {
    return periodConditions.stream()
        .anyMatch(condition -> condition.isSatisfiedBy(screening));
  }
  private boolean checkSequenceConditions(Screening screening) {
    return sequenceConditions.stream()
        .anyMatch(condition -> condition.isSatisfiedBy(screening));
  }
   */
}
