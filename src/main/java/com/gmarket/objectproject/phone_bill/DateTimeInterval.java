package com.gmarket.objectproject.phone_bill;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 시간대별 방식의 통화 요금을 계산하기 위해서는 통화의 시작 시간과 종료 시간뿐만 아니라 시작 일자와 종료 일자도 함께 고려해야한다.
 * 기존에는 일자에 대한 고려가 돼 있지 않았기 떄문에 여러 날에 걸친 통화에 대해서는 정확한 요금 계산이 불가능한 버그가 있었다.
 * 시간대별 방식을 구현하는 데 있어 핵심은 규칙에 따라 통화 시간을 분할하는 방법을 결정하는 것이다.
 * DateTimeInterval 클래스는 시작 시간, 종료 시간을 인스턴스 변수로 포함하며, 객체 생성을 위한 메서드인 of, toMidnight, from Midnight, during을 제공한다.
 */
public class DateTimeInterval {

  private LocalDateTime from;
  private LocalDateTime to;

  private DateTimeInterval(LocalDateTime from, LocalDateTime to) {
    this.from = from;
    this.to = to;
  }

  public static DateTimeInterval of(LocalDateTime from, LocalDateTime to) {
    return new DateTimeInterval(from, to);
  }

  public static DateTimeInterval toMidnight(LocalDateTime from) {
    return new DateTimeInterval(from,
        LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999_999_999)));
  }

  public static DateTimeInterval fromMidnight(LocalDateTime to) {
    return new DateTimeInterval(LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)), to);
  }

  public static DateTimeInterval during(LocalDate date) {
    return new DateTimeInterval(LocalDateTime.of(date, LocalTime.of(0, 0)),
        LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999_999_999)));
  }

  public Duration duration(){
    return Duration.between(from, to);
  }

  public LocalDateTime getFrom() {
    return from;
  }

  public LocalDateTime getTo() {
    return to;
  }

  /**
   * 통화 기간을 일자별로 분할해서 반환한다. days 메서드는 from과 to 사이에 포함된 날짜 수를 반환한다.
   * 만약 days 메서드의 반환값이 1보다 크다면 split 메서드를 호출해서 날짜 수만큼 분리한다.
   */
  public List<DateTimeInterval> splitByDay() {

    if(days() > 0){
      return splitByDay(days());
    }
    return Arrays.asList(this);
  }

  private long days() {
    return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay())
        .toDays();
  }

  private List<DateTimeInterval> splitByDay(long days) {
    List<DateTimeInterval> result = new ArrayList<>();
    addFirstDay(result);
    addMiddleDays(result, days);
    addLastDay(result);
    return result;
  }

  private void addFirstDay(List<DateTimeInterval> result) {
    result.add(DateTimeInterval.toMidnight(from));
  }

  private void addMiddleDays(List<DateTimeInterval> result, long days) {
    for(int loop=1; loop < days; ++loop){
      result.add(DateTimeInterval.during(from.toLocalDate().plusDays(loop)));
    }
  }

  private void addLastDay(List<DateTimeInterval> result) {
    result.add(DateTimeInterval.fromMidnight(to));
  }



}
