package com.gmarket.objectproject.reservation.factory;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Movie;
import com.gmarket.objectproject.reservation.pricing.AmountDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.SequenceCondition;
import java.time.Duration;

public class Client {
  private Factory factory;

  public Client(Factory factory) {
    this.factory = factory;
  }

  /**
   * 생성 책임을 CLient로 옮긴 배경에는 특정 컨텍스트에 묶여서는 안되지만 Client는 묶여도 상관이 없다는 전제가 깔려있지만 Movie를 사용하는 Client도 특정 컨텍스트에 묶이지 않기를 바란다고 해보자
   * Client 코드 역시 Movie를 생성 후 getFee()라는 메시지를 전송한다. -> Client 역시 생성과 사용의 책임을 함께 지니고 있다.
   * Movie를 생성하는 책임을 Client의 인스턴스를 사용할 문맥을 결정할 클라이언트로 옮김으로써 해결할 수 있지만 만약 객체 생성과 관련된 지식이 Client와 협력하는 클라이언트에게 까지 새어나가기를 원치 않는다고 가정해보자
   * 이경우 객체 생성과 관련된 책임만 전담하는 별도의 객체를 추가하고 Client는 이 객체를 사용하도록 만들 수 있다.
   * 이처럼 생성과 사용을 분리하기 위해 객체 생성에 특화된 객체를 Factory라고 부른다.
   *
   */
  public Money getAvatarFee() {
    /*
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
        new AmountDiscountPolicy(Money.wons(100), new SequenceCondition(10)));
     */
    Movie avatar = factory.createAvatarMovie(); //Movie와 AmountDiscountPolicy를 생성하는 책임을 모두 Factory로 이동할 수 있다.
    return avatar.getFee();
  }
}
