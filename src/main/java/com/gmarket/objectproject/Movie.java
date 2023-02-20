package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Movie {

  private String title;
  private Duration runningTime;
  private Money fee;
  private DiscountPolicy discountPolicy;


  public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
  }

  public Money getFee() {
    return fee;
  }


  public Money calculateMovieFee(Screening screening) {
    /**
     * 유연한 설계
     * 이 방식의 문제점은 할인 정책이 없는 경우를 예외 케이스로 취급하기 때문에 지금까지 일관성 있던 협력 방식이 무너지게 된다.
     * 기존 할인 정책의 경우 할인할 금액을 계산하는 책임이 DiscountPolicy의 자식 클래스에 있었지만 할인 정책이 없는 경우 할인 금액이 0원이라는 사실을 결정하는 책임이 DiscountPolicy 가 아닌 Movie 쪽에 있다.
     * 따라서 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이며, 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택해라.
     * NoneDiscountPolicy 를 생성해 Movie와 DiscountPolicy를 수정하지 않고 애플리케이션을 기능을 확장하였다. -> 추상화를 중심을 코드의 구조를 설계하면 유연하고 확장 가능한 설계를 만들 수 있다.
     * 추상화가 유연한 설계를 가능하게 하는 이유는 설계가 구체적인 상황에 결합되는 것을 방지하기 때문이다.
     * 결론은 유연성이 필요한 곳에 추상화를 사용하라
     *
     */
    /*
    if (discountPolicy == null) {
      return fee;
    }
     */
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
  /**
   * 코드 재사용
   * 코드 재사용을 위해서는 상속보다는 합성이 더 좋다 -> 합성은 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 재사용하는 방법이다.
   * 상속은 캡슐화를 위반하고 설계를 유연하게 만들지 않느다.
   * 1) 상속을 이용하기 위해서는 부모클래스의 내부 구조를 잘 알고 있어야하기 때문에 캡슐화를 위반한다(부모클래스의 구현이 자식 클래스에게 노출) -> 캡슐화 약화는 자식클래스가 부모클래스와 강결합 되도록 하므로 부모클래스 변경이 자식클래스 변경에 영향을 미친다.
   * 2) 상속은 부모클래스와 자식 클래스의 관계를 컴파일 시점에 결정한다-> 실행 시점에 객체의 종류를 변경하는것이 불가능하다.
   *  -> 대부분 언어에서는 이미생성된 객체의 클래스를 변경하는 방법을 제공하지 않기 때문에 변경할 인스턴스 생성 후 상태를 복사하는 법 밖에 없다.
   *  -> 단 인스턴스 변수로 연결한 기존 방법을 사용하면 아래 메서드 호출만으로 쉽게 변경이 가능하다.
   *
   * 합성
   * 인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법을 합성이라고 한다.
   * 합성은 상속이 가지는 두가지 문제점을 해결한다
   * -> 인터페이스에 정의된 메시지를 통해서만 재사용이 가능하기 때문에 구현을 효과적으로 캡슐화 할 수 있다.
   * -> 의존하는 인스턴스를 교체하는 것이 비교적 쉽기 때문에 설계를 유연하게 만든다
   * 상속은 클래스를 통해 강하게 결합되는데 비해 합성은 메시지를 통해 느슨하게 결합되므로 코드 재사용을 위해서는 상속보다는 합성을 선호하는것이 더 좋은 방법이다.
   * 그렇다고 상속을 절대 사용하지 말라는 것은 아니다 -> 상속과 합성을 조화해서 사용하자
   */
  public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
    this.discountPolicy = discountPolicy;
  }

  public static void main(String[] args) {
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
        new AmountDefaultDiscountPolicy(
            Money.wons(800), new SequenceCondition(1),
            new SequenceCondition(10),
            new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
        ));

    Movie titanic = new Movie("타이타닉", Duration.ofMinutes(180), Money.wons(11000),
        new PercentDefaultDiscountPolicy(
            0.1,
            new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
            new SequenceCondition(2),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
        ));

    Movie starWars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000),
        new NoneDefaultDiscountPolicy()); //할인 되지 않는 영화
  }
}
