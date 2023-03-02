package com.gmarket.objectproject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Movie {

  private String title; //영화 제목
  private Duration runningTime; //상영 시간
  private Money fee;  //기본 요금
  private List<DiscountCondition> discountConditions; //할인 조건 목록

  private MovieType movieType;  //할인 정책을 결정
  //한 시점에는 하나의 값(discountAmount/ discountPercent)만 사용이 가능하다
  private Money discountAmount; //할인 금액
  private double discountPercent; //할인 비율

  public MovieType getMovieType() {
    return movieType;
  }

  public Money calculateAmountDiscountedFee() {
    if (movieType != MovieType.AMOUNT_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee.minus(discountAmount);
  }

  public Money calculatePercentDiscountedFee() {
    if (movieType != MovieType.PERCENT_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee.minus(fee.times(discountPercent));
  }

  public Money calculateNoneDiscountedFee() {
    if (movieType != MovieType.NONE_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee;
  }

  public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
    for (DiscountCondition condition : discountConditions) {
      if(condition.getType() == DiscountConditionType.PERIOD){
        if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
          return true;
        }
      }else{
        if (condition.isDiscountable(sequence)){
          return true;
        }
      }
    }
    return false;
  }

}
