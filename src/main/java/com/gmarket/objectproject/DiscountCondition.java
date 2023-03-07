package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * DiscountCondition은 하나 이상의 변경 이유를 가지기 때문에 응집도가 낮다 -> 서로 연관성이 없는 기능이나 데이터가 하나의 클래스 안에 뭉쳐있다는 것을 의미한다.
 * 해당 문제를 해결하기 위해서는 변경의 이유에 따라 클래스를 분리해야한다.
 * 이러한 변경의 이유를 파악할 수 있는 방법
 * 1) 인스턴스 변수가 초기화 되는 시점을 살펴보자 -> 응집도가 높은 클래스는 인스턴스를 생성할 때 모든 속성을 함께 초기화한다. 반면 응집도가 낮은 클래스는 객체의 속성 중 일부만 초기화하고 일부는 초기화 되지 않은 상태로 남겨진다.
 * 따라서 함께 초기화되는 속성을 기준으로 코드를 분리해야한다.
 * 2) 메서드들이 인스턴스 변수를 사용하는 방식을 살펴보자 -> 모든 메서드가 객체의 모든 속성을 사용한다면, 클래스의 응집도가 높은 것이고, 사용하는 속성에 따라 그룹이 나뉜다면 응집도가 낮다고 볼 수 있다.
 * 이 경우 클래스의 응집도를 높이기 위해서 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드를 분리해야한다.
 *
 * 변경으로부터 보호하기
 * DiscountCondition이라는 역할이 Movie로부터 PeriodCondition, SequenceCondition의 존재를 감춘다.
 * DiscountCondition이라는 추상화가 구체적인 타입을 캡슐화 하므로 오직 DiscountCondition 인터페이스를 실체화하는 클래스를 추가하는것으로 할인 조건의 종류를 확장할 수 있다.
 * 변경 보호 패턴: 변경을 캡슐화하도록 책임을 할당하는 패턴
 * 하나의 클래스가 여러 타입의 행동을 구현하고 있는것처럼 보인다면 클래스를 분해하고 변경보호패턴에 따라 책임을 분산시켜라
 * 예측가능한 변경으로 인해 여러 클래스들이 불안정해진다면 변경보호패턴에 따라 안정적인 인터페이스 뒤로 변경을 캡슐화하라
 */
public interface DiscountCondition {
  /*
  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;


  public boolean isSatisfiedBy(Screening screening){
    if(type == DiscountConditionType.PERIOD){
      return isSatisfiedByPeriod(screening);
    }
    return isSatisfiedBySequence(screening);
  }
   */
  public boolean isSatisfiedBy(Screening screening);
}
