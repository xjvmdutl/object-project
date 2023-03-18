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
