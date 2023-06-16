package com.gmarket.objectproject.phone_bill;

import com.gmarket.objectproject.phone.Bill;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
  private RatePolicy ratePolicy;

  private List<Call> calls = new ArrayList<>();

  public Phone(RatePolicy ratePolicy) {
    this.ratePolicy = ratePolicy;
  }

  public List<Call> getCalls() {
    return Collections.unmodifiableList(calls);
  }

  public void call(Call call) {
    calls.add(call);
  }

  public Money calculateFee() {
    return ratePolicy.calculateFee(this);
  }

}