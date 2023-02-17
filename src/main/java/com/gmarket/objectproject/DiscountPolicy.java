package com.gmarket.objectproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

  private List<DiscountCondition> conditions = new ArrayList<>(); //하나의 할인 정책은 여러개의 할인 조건을 포함할 수 있다.

  public DiscountPolicy(DiscountCondition ... conditions){
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening){
    for(DiscountCondition each: conditions){
      if(each.isSatisfiedBy(screening)){
        return getDiscountAmount(screening); //실제 요금을 계산하는 부분을 추상메서드에게 위임
        //부모클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TemplateMethod 패턴이라고 한다.
      }
    }
    return Money.ZERO; //만족하는 할인조건이 하나도 없다면 할인 요금 0원 반환
  }

  abstract protected Money getDiscountAmount(Screening screening);
}
