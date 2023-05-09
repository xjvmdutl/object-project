package com.gmarket.objectproject.reservation.factory;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Movie;
import com.gmarket.objectproject.reservation.Screening;
import com.gmarket.objectproject.reservation.ServiceLocator;
import com.gmarket.objectproject.reservation.pricing.AmountDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.PercentDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.SequenceCondition;
import java.time.Duration;
import java.time.LocalDateTime;

public class Client {

  private Factory factory;

  public Client(Factory factory) {
    this.factory = factory;
  }

  public Money getAvatarFee() {
    //생성자 주입: 생성자를 이용해 의존성을 주입하고 있기 때문
    /*
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
        new AmountDiscountPolicy(Money.wons(100), new SequenceCondition(10)));
    Screening screening = new Screening(avatar, 10, LocalDateTime.now());
     */
    /**
     * setter 주입: 이미 생성된 Movie에 대해 setter 메서드를 이용해 의존성을 해결한다
     * setter 주입을 장점은 의존성의 대상을 런타임에 변경할 수 있다.
     * -> 생성자 주입을 통해 설정된 인스턴스는 객체의 생명주기 전체에 걸쳐 관계를 유지하는 반면, setter 주입을 사용하면 언제라도 의존 대상을 교체할 수 있다.
     * setter 주입을 단점은 객체가 올바로 생성되기 위해 어떤 의존성이 필수적인지를 명시적으로 표현할 수 없다.
     * -> setter 메서드는 객체가 생성된 후 호출되어야 하기 때문에 setter 메서드 호출을 누락한다면 객체는 비정상적인 상태로 생성될 것이다.
     */
    //avatar.setDiscountPolicy(new AmountDiscountPolicy(Money.wons(100), new SequenceCondition(10)));

    /**
     * 메서드 주입: 메서드 호출 주입으로도 부르며 메서드가 의존성을 필요로 하는 유일한 경우일 떄 사용할 수 있다.
     * 생성자 주입을 통해 의존성을 전달 받으면 객체가 올바른 상태로 생성되는데 필요한 의존성을 명확히 표현할 수 있으나, 주입된 의존성이 한 두개의 메서드에서만 사용된다면 각 메서드의 인자로 전달하는것이 나을 수 있다.
     */
    //avatar.calculateDiscountAmount(screening, new AmountDiscountPolicy(Money.wons(100), new SequenceCondition(10)));

    /*
    ServiceLocator.provide(new AmountDiscountPolicy(Money.wons(100), new SequenceCondition(10)));
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000));
     */
    ServiceLocator.provide(new PercentDiscountPolicy(0.1,new SequenceCondition(10))); //이후 Movie는 비율 할인 정책
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000));
    return avatar.getFee();
  }
}
