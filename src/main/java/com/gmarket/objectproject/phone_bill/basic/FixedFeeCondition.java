package com.gmarket.objectproject.phone_bill.basic;


import com.gmarket.objectproject.phone_bill.BasicRatePolicy;
import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.DateTimeInterval;
import com.gmarket.objectproject.phone_bill.FeeCondition;
import com.gmarket.objectproject.phone_bill.Money;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 개념적으로는 불필요한 FixedFeeCondition 클래스를 추가하고 findTimeIntervals 메서드의 반환 타입이 List임에도 항상 단 하나의 DateTimeInterval 인스턴스를 반환하지만, 개념적 무결성을 무너뜨리는 것보다는 약간의 부조화를 수용하는 편이 낫다.
 */
public class FixedFeeCondition implements FeeCondition {


  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {

    return Arrays.asList(call.getInterval()); //call의 전체 통화 시간을 반환
  }
}
