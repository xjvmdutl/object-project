package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
  private DiscountConditionType type; //할인 조건의 타입

  private int sequence; //상영 순번(순번 조건에서만 사용)

  private DayOfWeek dayOfWeek;  //요일
  private LocalTime startTime;  //시작 시간
  private LocalTime endTime;  //종료 시간

  public DiscountConditionType getType() {
    return type;
  }
  public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time){
    if(type != DiscountConditionType.PERIOD){
      throw new IllegalArgumentException();
    }
    return this.dayOfWeek.equals(dayOfWeek) &&
        this.startTime.compareTo(time) <= 0 &&
        this.endTime.compareTo(time) >= 0;
  }

  public boolean isDiscountable(int sequence){
    if(type != DiscountConditionType.SEQUENCE){
      throw new IllegalArgumentException();
    }
    return this.sequence == sequence;
  }

}
