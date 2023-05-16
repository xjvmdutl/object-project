package com.gmarket.objectproject.phone_bill;

import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * 중복과 변경
 * Phone과 매우 유사한 코드를 가지고 있으며 phone 클래스를 복사해서 구현했다.
 * 구현 시간을 절약한 대가로 지불해야 하는 비용은 예상보다 크다. 중복 코드가 존재하기 때문에 언제 터질지 모르는 시한폭탄을 안고 있는 것과 같다.
 */
public class NightlyDiscountPhone extends Phone{

  private static final int LATE_NIGHT_HOUR = 22;
 
  private double taxRate;
  private Money nightlyAmount;


  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount,Duration seconds, double taxRate) {
    super(regularAmount, seconds, taxRate);
    this.nightlyAmount = nightlyAmount;
  }

  @Override
  public Money calculateFee() {
    Money result = super.calculateFee();

    Money nightlyFee = Money.ZERO;
    for (Call call : getCalls()) {
      if(call.getFrom().getHour() >= LATE_NIGHT_HOUR){
        nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount).times(call.getDuration().getSeconds() / getSeconds().getSeconds()));
      }
    }
    return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
  }
}
