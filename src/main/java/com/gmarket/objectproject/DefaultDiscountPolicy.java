package com.gmarket.objectproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 추상화의 힘
 * 추상화를 사용하면 세부적인 내용을 무시한 채 상위 정책을 쉽고 간단하게 표현할 수 있다 => 세부사항에 억눌리지 않고 상위 개념만으로도 도메인의 중요한 개념을 설명할 수 있게 한다.
 * 재사용 가능한 설계의 기본을 이루는 디자인 패턴이나 프레임워크 모두 추상화를 이용해 상위 정책을 정의하는 객체지향의 메커니즘을 활용하고 있다.
 * 추상화를 이용해 상위 정책을 표현하면 기존 구조를 수정하지 않고도 새로운 기능을 쉽게 추가하고 확장할 수 있다.
 *
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy{

  private List<DiscountCondition> conditions = new ArrayList<>();

  public DefaultDiscountPolicy(DiscountCondition ... conditions){
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening){
    for(DiscountCondition each: conditions){
      if(each.isSatisfiedBy(screening)){
        return getDiscountAmount(screening);
      }
    }
    return Money.ZERO;
  }



  abstract protected Money getDiscountAmount(Screening screening);
}
