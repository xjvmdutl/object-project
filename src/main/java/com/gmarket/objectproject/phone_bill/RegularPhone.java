package com.gmarket.objectproject.phone_bill;

import java.time.Duration;

public class RegularPhone extends Phone {

  private Money amount;
  private Duration seconds;


  public RegularPhone(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }

  /*
  @Override
  protected Money afterCalculated(Money fee) {
    return fee; //요금을 수정할 필요 x
  }
   */

}
