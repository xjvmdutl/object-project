package com.gmarket.objectproject.phone_bill;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {

  //private static final int LATE_NIGHT_HOUR = 22;


  private Money amount;
  /*
  private Money nightlyAmount;
  private Money regularAmount;
  private PhoneType type;
   */
  private Duration seconds;
  private List<Call> calls = new ArrayList<>();

  private double taxRate;




  public Phone(Money amount, Duration seconds, double taxRate) {
  //public Phone(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
    this.taxRate = taxRate;
  }
  /*
  public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  public Phone(Money amount, Money nightlyAmount, Money regularAmount, Duration seconds,
      PhoneType type) {
    this.amount = amount;
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
    this.type = type;
  }
   */

  public void call(Call call) {
    calls.add(call);
  }

  public List<Call> getCalls() {
    return calls;
  }

  public Duration getSeconds() {
    return seconds;
  }

  public Money getAmount() {
    return amount;
  }

  public double getTaxRate() {
    return taxRate;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
    }
    return result.plus(result.times(taxRate));
    //return result;
    /**
     * 하나의 클래스로 만들어서 작성할 수 있지만 타입 코드를 사용하는 클래스는 낮은 응집도와 높은 결합도에 문제에 시달린다.
     */
    /*
    Money result = Money.ZERO;
    for (Call call : calls) {
      if (type == PhoneType.REGULAR) {
        result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
      } else {
        if(call.getFrom().getHour() >= LATE_NIGHT_HOUR){
          result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }else {
          result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }
      }
    }
    return result;
     */
  }
}
