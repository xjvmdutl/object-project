package com.gmarket.objectproject.phone_bill.basic;

import com.gmarket.objectproject.phone_bill.BasicRatePolicy;
import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.DateTimeInterval;
import com.gmarket.objectproject.phone_bill.Money;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * - 통화 기간을 일자별로 분리한다.
 * - 일자별로 분리된 기간을 다시 시간대별 규칙에 따라 분리한 후 각 기간에 대해 요금을 계산한다.
 * 책임을 할당하는 기본 원칙은 책임을 수행하는 데 필요한 정보를 가장 잘 알고 있는 정보 전문가에게 할당하는 것이다.
 * 통화 기간을 일자 단위로 나누는 책임은 DateTimeInterval에게 할당하고, Call이 DateTimeInterval에게 분할을 요청하도록 협력을 설계하는 것이 적절하다,.
 * 시간대별 기준을 잘 알고 있는 곳은 요금 정책이며, 여기서는 TimeOfDayDiscountPolicy 아름의 클래스로 구현할 것이다.
 * 이 클래스의 가장 중요한 것은 시간에 따라 서로 다른 요금 규칙을 정의하는 방법을 결정하는 것이다. -> 시간대별 방식을 담당한 개발자는 이 문제를 4개의 서로 다른 List를 가지는 것으로 해결
 */
public class TimeOfDayDiscountPolicy extends BasicRatePolicy {

  private List<LocalTime> starts = new ArrayList<>();
  private List<LocalTime> ends = new ArrayList<>();
  private List<Duration> durations = new ArrayList<>();
  private List<Money> amounts = new ArrayList<>();

  @Override
  protected Money calculateCallFee(Call call) {
    Money result = Money.ZERO;
    /**
     * TimeOfDayDiscountPolicy는 통화기간을 알고 있는 Call에게 일자별로 통화기간을 분리할 것을 요청한다.
     * Call은 이 요청을 DateTimeInterval에게 위임한다.
     * DateTimeInterval은 기간을 일자 단위로 분할한 후 분할된 목록을 반환한다.
     * Call은 반환된 목록을 그대로 TimeOfDayDiscountPolicy 에게 반환한다.
     * TimeOfDayDiscountPolicy는 일자별 기간의 목록을 대상으로 루프를 돌리면서 각 시간대별 기준에 맞는 시작시간과 종료시간을 얻는다
     */
    for (DateTimeInterval interval : call.splitByDay()) {
      for (int loop = 0; loop < starts.size(); ++loop) {
        result.plus(amounts.get(loop).times(
            Duration.between(from(interval, starts.get(loop)), to(interval, ends.get(loop)))
                .getSeconds() / durations.get(loop).getSeconds()));
      }
    }
    return result;
  }


  private LocalTime from(DateTimeInterval interval, LocalTime from) {
    return interval.getFrom().toLocalTime().isBefore(from) ?
        from : interval.getTo().toLocalTime();
  }

  private Temporal to(DateTimeInterval interval, LocalTime to) {
    return interval.getTo().toLocalTime().isAfter(to) ?
        to : interval.getTo().toLocalTime();
  }

}
