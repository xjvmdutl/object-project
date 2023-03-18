package com.gmarket.objectproject.recurring;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {

  private String subject;
  private LocalDateTime from;
  private Duration duration;

  public Event(String subject, LocalDateTime from, Duration duration) {
    this.subject = subject;
    this.from = from;
    this.duration = duration;
  }



  public boolean isSatisfied(RecurringSchedule schedule){
    if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
        !from.toLocalTime().equals(schedule.getFrom()) ||
        !duration.equals(schedule.getDuration())
    ) {
      return false;
    }
    return true;
  }

  public void reschedule(RecurringSchedule schedule) {
    //Contract.Requires(isSatisfied(schedule)); //C#에서만 사용가능
    /**
     * isSatisfied 메서드의 반환값이 true일 경우에만 reschedule 메서드를 호출할 수 있다는 것을 명시적으로 표현한다.
     * 이렇게 작성된 계약은 문서화로 끝나는 것이 아니라 제약 조건의 만족여부를 실행 중에 체클할 수 있다.
     * 또한 이 조건들을  코드로부터 추출해서 문서를 만들어주는 자동화 도구도 제공한다.
     */
    from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
    duration = schedule.getDuration();
  }

  private long daysDistance(RecurringSchedule schedule) {
    return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
  }

  public static void main(String[] args) {
    RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY,
        LocalTime.of(10, 30), Duration.ofMinutes(30));

    Event meeting = new Event(
        "회의",
        LocalDateTime.of(2019, 5, 8, 10, 30),
        Duration.ofMinutes(30));
    assert meeting.isSatisfied(schedule) == false;
   if(!meeting.isSatisfied(schedule)){
     meeting.reschedule(schedule);
   }
  }
}
