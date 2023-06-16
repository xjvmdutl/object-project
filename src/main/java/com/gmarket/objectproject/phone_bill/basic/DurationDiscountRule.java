package com.gmarket.objectproject.phone_bill.basic;

import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.Money;
import com.gmarket.objectproject.phone_bill.Phone;
import java.time.Duration;

/**
 * 규칙을 정의하는 새로운 클래스를 추가하기로 했다. 요일별 방식과 다른 점은 코드를 재사용하기 위해 FixedFeePolicy를 상속했다고 가정하자
 * DurationDiscountRule 클래스의 calculate 메서드 안에서 부모 클래스의 calculateFee 메서드를 호출하는 부분을 살펴보자
 * 부모 클래스의 calculateFee는 phone 클래스를 파라미터로 받기 때문에 이를 재사용하기위해 임시 Phone을 생성한다.
 * - FixedFeePolicy는 상속을 위해 설계된 클래스가 아니고 DurationDiscountRule는 FixedFeePolicy의 서브타입이 아니다.
 * - 상속 받은 이뉴는 FixedFeePolicy에 선언된 이스턴스 변수(amount, seconds)와 calculateFee 메서드를 재사용하기 위해서로 코드 재사용을 위해 상속을 사용한 것이다.
 * - 두 클래스 사이의 강한 결합도는 설계 개선과 새로운 기능의 추가를 방해한다.
 * - 이 코드는 이해하기도 어려운데 FixedFeePolicy의 calculateFee 메서드를 재사용하기 위해 DurationDiscountRule의 calculate 메서드 안에서 Phone과 Call의 인스턴스를 생성하는 것이 꽤나 부자연스러워 보이기 때문이다.
 * - 이것은 상속을 위해 설계된 클래스가 아닌 FixedFeePolicy를 재사용하기 위해 억지로 코드를 비튼 결과로, 이런 배경지식이 없는 상황에서 이 코드를 직면했다면 새로운 Phone,Call 인스턴스를 생성한 이유를 쉽게 이해할 수 없을 것이다.
 */
public class DurationDiscountRule extends FixedFeePolicy {

  private Duration from;
  private Duration to;

  public DurationDiscountRule(Duration from, Duration to, Money amount, Duration seconds) {
    super(amount, seconds);
    this.from = from;
    this.to = to;
  }

  public Money calculate(Call call) {
    if (call.getDuration().compareTo(to) > 0) {
      return Money.ZERO;
    }
    if (call.getDuration().compareTo(from) < 0) {
      return Money.ZERO;
    }
    //부모 클래스의 calculateFee(phone)은 phone 클래스를 파라미터로 받는다.
    //calculateFee(phone)을 재사용하기 위해 데이터를 전달할 용도로 임시 phone을 만든다.
    Phone phone = new Phone(null);
    phone.call(new Call(call.getFrom().plus(from),
        call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()));
    return super.calculateFee(phone);
  }
}
