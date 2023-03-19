package com.gmarket.objectproject.phone;

import java.util.List;

public interface RatePolicy {
  Money calculateFee(List<Call> calls);
  //Money calculateFee(List<Call> calls) throws EmptyCallException;

}
