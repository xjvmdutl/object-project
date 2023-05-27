package com.gmarket.objectproject.phone_bill.basic;


import com.gmarket.objectproject.phone_bill.BasicRatePolicy;
import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.Money;
import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
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
