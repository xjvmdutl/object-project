package com.gmarket.objectproject.phone;

import java.time.Duration;
import java.time.LocalDateTime;

public class RunApplication {

  public static void main(String[] args) {
    /*
    //서브 타입에 더 강력한 사전조건을 정의할 수 없다.
    Phone phone = new Phone(new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)));
    Bill bill = phone.publishBill();
    System.out.println("bill = " + bill);
     */
    /*
    //서브타입에 더 완화된 사후조건을 정의할 수 없다.
     */
    /*
    Phone phone = new Phone(
        new RateDiscountablePolicy(
            Money.wons(1000),
            new RegularPolicy(Money.wons(100), Duration.ofSeconds(10))
        )
    );
    phone.call(new Call(
        LocalDateTime.of(2017, 1, 1, 10, 10),
        LocalDateTime.of(2017, 1, 1, 10, 11)));
    Bill bill = phone.publishBill();
    System.out.println("bill = " + bill);
     */
    //슈퍼타입의 불변식은 서브타입에서도 반드시 유지돼야 한다.
    /*
    RateDiscountablePolicy policy = new RateDiscountablePolicy(
        Money.wons(1000),
        new RegularPolicy(Money.wons(100), Duration.ofSeconds(10))
    );
    policy.changeNext(null); //불변식 위반
     */
    /**
     * 서브타입은 슈퍼타입이 발생시키는 예외와 다른 타입의 예외를 발생시켜서는 안된다.
     * 일반적으로 부모 클래스가 던지는 예외가 속한 상속 계층이 아닌 다른 상속 계층에 속하는 예외를 던질 경우 자식 클래스는 부모 클래스를 대체할 수 없다 -> 서브타입이 아니다.
     * 클라이언트의 관점에서 부모 클래스에 대해 기대했던 것보다 더 적은 일을 수행하는 자식 클래스는 부모클래스와 동일하지 않다.
     * -> 부모클래스보다 못한 자식 클래스는 서브타입이 아니다.
     *
     * 서브타입의 리턴 타입은 공변성을 가져야 한다.
     * T: 부모 S: 자식
     * 공변성: S와 T 사이의 서브타입 관계가 그대로 유지된다. 서브타입인 S가 슈퍼타입인 T 대신 사용될 수 있다.
     * 반공변성: S와 T 사이의 서브타입 관계가 역전된다. 해당 위치에서 슈퍼타입인 T가 서브타입인 S 대신 사용될 수 있다.
     * 무공변성: S와 T 사이에는 아무런 관계도 존재하지 않는다.
     */
  }
}
