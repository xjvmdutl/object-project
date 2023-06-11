package com.gmarket.objectproject.reservation.pricing;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.DiscountPolicy;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;
import java.time.LocalTime;


public class BrokenDiscountPolicy extends DiscountPolicy {

  public BrokenDiscountPolicy(DiscountCondition... conditions) {
    super(conditions);
  }
  /**
   * BrokenDiscountPolicy 클래스가 DiscountPolicy 클래스의 자식 클래스이기 떄문에 컴파일러는 아무런 제약없이 업캐스팅을 허용한다.
   * BrokenDiscountPolicy의 사전조건을 강화하면 협력이 실패한다. BrokenDiscountPolicy는 클라이언트 관점에서 DiscountPolicy를 대체할 수 없기 때문에 서브타입이 아닌것이다.
   * 서브타입에 더 강력한 사전 조건을 정의할 수 없다.
   * 서브타입에 슈퍼타입과 같거나 더 약한 사전조건을 정의할 수 있다.
   * 서브타입에 슈퍼타입과 같거나 더 강한 사후조건을 정의할 수 있다.
   * 서브타입에 더 약한 사후조건을 정의할 수 없다.
   * 어떤 타입이 슈퍼타입에서 정의한 사전조건보다 더 약한 사전조건을 정의하고 있다면 그 타입은 서브타입이 될 수 있지만 더 강한 사전조건을 정의한다면 서브타입이 될 수 없다.
   * 어떤 타입이 슈퍼타입에서 정의한 사후조건보다 더 강한 사후조건을 정의하더라도 그 타입은 여전히 서브타입이지만 더 약한 사후조건을 정의한다면 서브타입의 조건이 깨지고 만다.
   * 계약에 의한 설계는 클라이언트 관점에서의 대체 가능성을 계약으로 설명할 수 있다는 사실을 잘 보여준다. 따라서 서브타이핑을 위해 상속을 사용하고 있다면 부모 클래스가 클라이언트와 맺고 있는 계약에 관해 깊이 있게 고민하라
   * 상속을 사용하지 않고도 타입 계층을 구현할 수 있는 다양한 방법이 존재한다. 또한 타입과 타입계층을 구현하는 방법은 사용하는 프로그래밍 언어나 타입 체크의 시점에 따라 달라질 수 있다.
   */
  @Override
  public Money calculateDiscountAmount(Screening screening) {
    //checkPrecondition(screening); //주석 처리로 사전 조건 약화
    //checkStrongerPrecondition(screening); //더 강력한 사전조건

    Money amount = screening.getMovieFee();
    //checkPostcondition(amount);
    checkWeakerPostcondition(amount);//더 약한 사후조건
    //checkStrongerPostcondition(amount); //더 강력한 사후조건

    return amount;
  }


  private void checkStrongerPrecondition(Screening screening) {
    assert screening.getEndTime().toLocalTime().isBefore(LocalTime.MIDNIGHT);
  }
  private void checkStrongerPostcondition(Money amount) {
    assert amount.isGreaterThanOrEqual(Money.wons(1000));
  }

  private void checkWeakerPostcondition(Money amount) {
    assert amount != null;
  }
  @Override
  protected Money getDiscountAmount(Screening Screening) {
    return Money.ZERO;
  }
}
