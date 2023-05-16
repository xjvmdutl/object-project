package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone { //추상화에 의존

  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;

  private Money regularAmount;
  private Duration seconds;

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(taxRate);
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }


  //private List<Call> calls = new ArrayList<>();

  /*

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }
   */

  /*
  public Money calculateFee() { //부모의 코드와 동일해졋고 이제 부모 클래스로 옮기면 된다.
    Money result = Money.ZERO;
    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result;
  }
   */

  @Override
  protected Money calculateCallFee(Call call) {
    if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
      return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    } else {
      return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
  }
}
