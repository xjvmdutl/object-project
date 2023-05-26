package com.gmarket.objectproject.phone_bill;

public interface RatePolicy {
  Money calculateFee(Phone phone);
}
