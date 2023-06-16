package com.gmarket.objectproject.phone_bill.basic;

import com.gmarket.objectproject.phone_bill.Call;
import com.gmarket.objectproject.phone_bill.DateTimeInterval;
import com.gmarket.objectproject.phone_bill.Money;
import com.gmarket.objectproject.phone_bill.Phone;
import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 요일별 방식은 요일별로 요금 규칙을 다르게 설정할 수 있다. 요일병 방식을 개발하는 개발자는 규칙을 DayOfWeekDiscountRule이라는 하나의 클래스로 구현하는 것이
 * 더 나은 설계라고 판단했다. calculate 메서드는 파라미터로 전달된 interval이 요일 조건을 만족시킬 경우 단위 시간과 단위 요금을 이용해 통화 요금을 계산한다.
 * 요일병 방식 역시 통화 기간이 여러 날에 걸쳐 있을 수 있다. -> 시간대별 방식과 동일하게 통화 기간을 날짜 경계로 분리하고 분리된 각 통화 기간을 요일별로 설정된 요금
 * 정책에 따라 적절하게 계산해야 한다.
 */

public class DayOfWeekDiscountRule {

  private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
  private Duration duration = Duration.ZERO;
  private Money amount = Money.ZERO;

  public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
    this.dayOfWeeks = dayOfWeeks;
    this.duration = duration;
    this.amount = amount;
  }

  public Money calculate(DateTimeInterval interval) {
    if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
      return amount.times(interval.duration().getSeconds() / duration.getSeconds());
    }
    return Money.ZERO;
  }
}

