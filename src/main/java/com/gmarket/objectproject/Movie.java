package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

/**
 * 상속
 * 어느곳에서도 DiscountPolicy 정책을 결정하는 조건문이 없는데 어떻게 영화요금을 계산할 때 할인 정책과 비율할인 정책을 선택할 수 있을까? -> 상속, 다형성 이해
 * Movie 클래스는 DiscountPolicy 객체에 의존하고 있으며, AmountDiscountPolicy와 PercentDiscountPolicy가
 * DiscountPolicy 에 의존하고 있다. Movie 인스턴스는 실행 시에는 AmountDiscountPolicy와 PercentDiscountPolicy에 의존해야
 * 하지만 코드 수준에서 Movie 클래스는 두 클래스 어디에도 의존하고 있지 않고 추상클래스(DiscountPolicy)에만 의존하고 있다
 * 상속은 객체지향에서 코드를 재사용하기 위해 가장 널리 사용되는 방법으로 클래스 사이의 관계를 설정하는 것만으로 기존 클래스가 가지고 있는 모든 속성과 행동을 새로운 클래스에 포함시킬 수 있다.
 * 또한 상속을 이용하면 부모클래스의 구현은 공유하면서도 행동이 다른 자식 클래스를 쉽게 추가할 수 있다.
 * 부모 클래스와 다른 부분만을 추가해서 새로운 클래스를 쉽고 빠르게 만드는 방법을 차이에 의한 프로그래밍이라고 한다.
 * 상속이 가치있는 이유는 부모클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있기 때문이다
 * -> 인터페이스는 객체가 이해할 수 있는 메시지의 목록을 정의한 것이며, 상속을 통해 자식클래스는 자신의 인터페이스에 부모 클래스의 인터페이스를 포함하게 된다.
 * 결과적으로 자식 클래스는 부모 클래스가 수신할 수 있는 모든 메시지를 수신할 수 있기 떄문에 외부 객체는 자식 클래스를 부모 클래스와 동일한 타입으로 간주할 수 있다.
 *
 * 구현 상속/ 인터페이스 상속
 * 구현 상속(서브 클래싱): 순수하게 코드를 재사용하기 위한 목적으로 상속을 사용하는것
 * 인터페이스 상속(서브 타이핑): 다형적인 협력을 위해 부모 클래스와 자식 클래스가 인터페이스를 공유할 수 있도록 상속을 이용하는 것
 * 상속은 구현 상속이 아닌 인터페이스 상속을 위해 사용해야 한다 -> 구현을 재사용할 목적으로 상속을 사용하면 변경에 취약한 코드를 낳게 될 확률이 높기 때문
 *
 * 다형성
 * 다형성 : 동일한 메시지를 전송하지만 실제로 어떤 메서드가 실행될 것인지는 메시지를 수신하는 객체의 클래스가 무엇인지에 따라 달라지는 것
 * 다형성은 객체지향 프로그램의 컴파일 시간 의존성과 실행 시간 의존성이 다를 수 있다는 사실을 기반으로 한다
 * -> 컴파일 시간 의존성과 실행시간 의존성을 다르게 만들 수 있는 객체지향의 특성을 이용해 서로 다른 메서드를 실행할 수 있게 한다.
 * 다형적인 협력에 참여하는 객체들은 모두 같은 메시지를 이해할 수 있어야한다(인터페이스가 동일해야한다)
 * -> DiscountPolicy로 부터 동일한 인터페이스를 물려받았고, 인터페이스를 통일하기 위해 구현 방법이 상속이다.
 * 다형성을 구현하는 방법은 다양하지만 메시지에 응답하기 위해 실행될 메서드를 컴파일 시점이 아닌 실행시점에 결정한다는 공통점이 있다
 * 동적 바인딩, 지연 바인딩 : 메시지와 메서드를 실행시점에 바인딩
 * 정적 바인딩, 초기 바인딩 : 컴파일 시점에 실행될 함수나 프로시저를 결정하는 것
 * 객체자향이 컴파일 시점의 의존성과 실행시점의 의존성을 분리하고 하나의 메시지를 선택적으로 서로 다른 메서드에 연결할 수 있는 이유가 지연 바인딩이라는 메커니즘을 사용했기 때문이다.
 *
 */
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
     * Movie가 DiscountPolicy의 인터페이스에 정의된 calculateDiscountAmount 메시지를 전송하고 있고 AmountDiscountPolicy, PercentDiscountPolicy 인터페이스에도 이 오퍼레이션이 포함되어 있다.
     * Movie 입장에서는 자신과 협력하는 객체가 어떤 클래스의 인스턴스가 중요한것이 아닌 calculateDiscountAmount 메시지를 수신할 수 있다는 사실이 중요하다.
     * calculateDiscountAmount 메시자만 이해할 수 있다면 어떤 클래스의 인스턴스인지는 상관하지 않는다.
     * 자식 클래스는 상속을 통해 부모 클래스의 인터페이스를 물려받기 떄문에 부모클래스 대신 사용될 수 있으며 컴파일러는 코드상 부모클래스가 나오는 모든 장소에서 자식클래스를 사용하는 것을 허용한다.
     * 자식 클래스가 부모클래스를 대신하는 것을 업캐스팅이라고 부르며, 일반적으로 클래스 다이어그램을 작성할 때 부모 클래스를 자식클래스 위에 위치시키기 떄문에 이렇게 부른다.
     */
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

  public static void main(String[] args) {
    /**
     * 실행시 해당 객체(Movie)는 AmountDiscountPolicy에 의존하게 된다.
     * 코드의 의존성과 실행시점의 의존성은 서로 다를 수 있다(클래스 사이 의존성 !== 객체사이의 의존성)
     * -> 유연하고 쉽게 재사용이 가능하며, 확장가능한 객체지향 설계가 가지는 특징은 코드의 의존성과 객체사이 의존성이 다르다는 것이다.
     * 단, 코드의 의존성과 실행시점에 의존성이 다르면 다를수록 코드를 이해하기는 어려워진다 -> 코드 뿐만 아니라 객체를 생성하고 연결하는 부분까지 찾아야하기 때문에
     * 이와 같이 의존성의 양면성은 설계가 트레이드오프의 산물이란 사실을 잘 보여준다.
     *
     * 설계가 유연해질수록 코드를 이해하고 디버깅하기는 점점 어려워지고, 유연성을 억제하면 코드를 이해하고 디버깅은 쉬워지지만 재사용성과 확장 가능성은 낮아진다.
     * 훌룡한 객체지향 설계를 하기 위해서는 항상 유연성과 가독성 사이에서 고민해야 하며, 무조건 유연한 설계도, 무조건 읽기 쉬운 코드도 정답이 아니다!!
     */
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
        new AmountDiscountPolicy(
            Money.wons(800), new SequenceCondition(1),
            new SequenceCondition(10),
            new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
        ));

    Movie titanic = new Movie("타이타닉", Duration.ofMinutes(180), Money.wons(11000),
        new PercentDiscountPolicy(
            0.1,
            new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
            new SequenceCondition(2),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
        ));
  }
}
