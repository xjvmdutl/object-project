package com.gmarket.objectproject.phone_bill;

public abstract class BasicRatePolicy implements RatePolicy{

  @Override
  public Money calculateFee(Phone phone) {
    Money result = Money.ZERO;
    for(Call call: phone.getCalls()){
      result.plus(calculateCallFee(call));
    }
    return result;
  }

  protected abstract Money calculateCallFee(Call call);
}
