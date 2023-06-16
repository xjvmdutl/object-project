package com.gmarket.objectproject.phone_bill;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {

  private DateTimeInterval interval; //인터벌 변수 하나로 묶을 수 있다

  public Call(LocalDateTime from, LocalDateTime to) {
    this.interval = DateTimeInterval.of(from, to);
  }

  public Duration getDuration() {
    return interval.duration();
  }

  public LocalDateTime getFrom() {
    return interval.getFrom();
  }

  public LocalDateTime getTo() {
    return interval.getTo();
  }

  public DateTimeInterval getInterval() {
    return interval;
  }

  public List<DateTimeInterval> splitByDay() {
    return interval.splitByDay();
  }
}
