package com.gmarket.objectproject.phone_bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
  private RatePolicy ratePolicy; //폰 내부에 RatePolicy 참조자가 포함돼 있다.
  //phone이 다양한 요금 정책과 협력할 수 있어야 하므로 요금 정책의 타입이 RatePolicy라는 인터페이스로 정의돼 있다는 것에도 주목하자

  private List<Call> calls = new ArrayList<>();

  public Phone(RatePolicy ratePolicy) {
    this.ratePolicy = ratePolicy;
  }

  public List<Call> getCalls() {
    return Collections.unmodifiableList(calls);
  }

  public Money calculateFee(){
    return ratePolicy.calculateFee(this);
  }
}