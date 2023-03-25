package com.gmarket.objectproject.phone;

import java.time.Duration;

public class RegularPolicy extends BasicPolicy {

  private Money amount;
  private Duration seconds;

  public RegularPolicy(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }
}
