package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class Client {

  public static void main(String[] args) {
    /**
     * Phone과 연결되는 RatePolicy 인터페이스의 구현 클래스가 어떤 타입인지에 따라 요금을 계산하는 방식이 달라진다.
     */
    Phone basicPhone = new Phone(
        new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))); //일반 요금제
    Phone nightlyPhone = new Phone(
        new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));
    //상속을 사용한 설계보다 복잡하고 정해진 규칙에 따라 객체를 생성하고 조합해야 하기 때문에 처음에는 코드를 이해하기 어렵지만 익숙해지면 객체를 조합하고 사용하는 방식이 상속을 사용한 방식보다 더 예측 가능하고 일관성 있다는 사실을 알것이다.
    Phone taxableBasicPhone = new Phone(
        new TaxablePolicy(0.05,
            new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));
    Phone taxableAndRateDiscountBasicPhone = new Phone(
        new TaxablePolicy(0.05,
            new RateDiscountablePolicy(Money.wons(1000),
                new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
    Phone RateDiscountAndTaxableBasicPhone = new Phone(
        new RateDiscountablePolicy(Money.wons(1000),
            new TaxablePolicy(0.05, new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
    Phone RateDiscountAndTaxableNightlyPhone = new Phone(
        new RateDiscountablePolicy(Money.wons(1000),
            new TaxablePolicy(0.05,
                new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)))));
  }
}
