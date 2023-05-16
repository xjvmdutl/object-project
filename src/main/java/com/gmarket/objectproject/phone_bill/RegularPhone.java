package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class RegularPhone extends Phone { //추상화에 의존

  private Money amount;
  private Duration seconds;
  //private List<Call> calls = new ArrayList<>();


  public RegularPhone(Money amount, Duration seconds,double taxRate) {
    super(taxRate);
    this.amount = amount;
    this.seconds = seconds;
  }

  /*
  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result;
  }
   */

  @Override
  protected Money calculateCallFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }

}
