package com.gmarket.objectproject;

/**
 *  인터페이스와 다형성
 *  DiscountPolicy를 추상클래스로 구현함으로써 자식 클래스들이 인터페이스와 내부 구현을 함께 상속받도록 만들었으나 종종 구현은 공유할 필요 없이 순수 인터페이스만 공유하고 싶을 경우도 있다.
 *  이를 위해 C#, java는 인터페이스라는 프로그래밍 요소를 제공한다, C++같은 경우 추상 기반 클래스를 통해 자바의 인터페이스 개념을 구현할 수 있다
 *  DiscountCondition 같은 경우 구현을 공유할 필요가 없기 때문에 인터페이스를 이용해 타입 계층을 구현했으며, SequenceCondition, PeriodCondition은 동일한 인터페이스를 공유하며 다형적인 협력에 참여할 수 있다.
 *  SequenceCondition, PeriodCondition은 isSatisfiedBy 메시지를 이해할 수 있기 때문에 클라이언트인 DiscountPolicy의 입장에서는 둘은 DiscountCondition 과 아무 차이도 없다
 *  DiscountCondition을 실체화 하는 클래스들은 동일한 인터페이스를 공유하며, DiscountCondition을 대신해 사용될 수 있으며, 업캐스팅이 적용되며 협력은 다형적이다.
 */
public interface DiscountCondition {
  boolean isSatisfiedBy(Screening screening);
}
