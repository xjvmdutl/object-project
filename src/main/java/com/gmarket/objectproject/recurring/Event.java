package com.gmarket.objectproject.recurring;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {

  private String subject; //주제
  private LocalDateTime from; //시작 일시
  private Duration duration; //소요 시간

  public Event(String subject, LocalDateTime from, Duration duration) {
    this.subject = subject;
    this.from = from;
    this.duration = duration;
  }

  //현재 이벤트가 RecurringSchedule이 정의한 반복 일정 조건을 만족하는지 검사하는 메서드
  //쿼리 + 명령
  public boolean isSatisfied(RecurringSchedule schedule){
    if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
        !from.toLocalTime().equals(schedule.getFrom()) ||
        !duration.equals(schedule.getDuration())
    ) {
      /**
       * reschedule(schedule); //이벤트 객체의 상태를 수정한다.
       * //RecurringSchedule에 설정에 만족하지 못할 경우 Event의 상태를 조건을 만족하도록 변경한 후, false를 반환
       * //명령과 쿼리를 뒤섞으면, 실행 결과를 예측하기가 어려워질 수 있다. => isSatisfied 메서드처럼 겉으로 보기에 쿼리처럼 보이지만 내부적으로 부수효과를 가지는 메서드는 이해하기 어렵고 잘못 사용하기 쉬우며 버그를 양산하는 경향이있다.
       */
      //순수한 쿼리로 변경되었다
      return false;
    }
    return true;
  }
  /**
  private void reschedule(RecurringSchedule schedule) {
    //전달된 RecurringSchedule의 조건에 맞게 변경한다.
    from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
    duration = schedule.getDuration();
  }
   */
  //쿼리와 명령을 분리
  public void reschedule(RecurringSchedule schedule) {
    from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
    duration = schedule.getDuration();
  }

  private long daysDistance(RecurringSchedule schedule) {
    return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
  }

  public static void main(String[] args) {
    /**
    RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY,
        LocalTime.of(10, 30), Duration.ofMinutes(30));

    Event meeting = new Event(
        "회의",
        LocalDateTime.of(2019, 5, 8, 10, 30),
        Duration.ofMinutes(30));
    //1번 실행했을때와 2번 실행했을떄 결과가 다르다.
    assert meeting.isSatisfied(schedule) == true;
    assert meeting.isSatisfied(schedule) == false;
     */
    RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY,
        LocalTime.of(10, 30), Duration.ofMinutes(30));

    Event meeting = new Event(
        "회의",
        LocalDateTime.of(2019, 5, 8, 10, 30),
        Duration.ofMinutes(30));
    assert meeting.isSatisfied(schedule) == false;
   if(!meeting.isSatisfied(schedule)){ //해당 쿼리는 이제 몇번을 실행하더라도 같은 결과를 반환한다.
     meeting.reschedule(schedule);//클라이언트에서 이제 명령을 직접 실행할 수 있다(이벤트를 사용하는 쪽에서 이를 결정한다)
   }
  }
}
