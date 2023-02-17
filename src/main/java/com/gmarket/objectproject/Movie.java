package com.gmarket.objectproject;

import java.time.Duration;

/**
 * 제목, 상영시간, 기본요금, 할인 정책
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

  /**
   * disCountPolicy에 calculateMovieFee 메시지를 전송해 할인 요금을 반환받는다.
   * Movie는 기본요금인 fee에서 반환된 할인요금을 차감한다.
   * @param screening
   * @return
   */
  public Money calculateMovieFee(Screening screening){
    /**
     * 어떤 할인 정책을 사용할 것이지 결정하는 코드가 존재하지 않는다. -> 두가지 개념이 숨겨져 있기 때문ㄴ( 상속, 다형성 -> 추상화 원리)
     * 비율 할인 정책과 금액 할인 정책을 코드는 유사함으로 공통코드를 보고나할 장소가 필요하다 -> DiscountPolicy
     * 부모 클래스인 DiscountPolicy에 중복코드를 두고 AmountDiscountPolicy, PercentDiscountPolicy가 이 클래스를 상속받게 할 것이다.
     * 실제 애플리케이션에서도 DiscountPolicy의 인스턴스를 생성할 필요가 없기 때문에 추상클래스로 구현하자
     */
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
}
