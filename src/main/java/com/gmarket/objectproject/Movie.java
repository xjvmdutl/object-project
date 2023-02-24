package com.gmarket.objectproject;

import java.time.Duration;
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
  public void setMovieType(MovieType movieType) {
    this.movieType = movieType;
  }

  public Money getFee() {
    return fee;
  }

  public void setFee(Money fee) {
    this.fee = fee;
  }

  public List<DiscountCondition> getDiscountConditions() {
    return Collections.unmodifiableList(discountConditions);
  }

  public void setDiscountConditions(List<DiscountCondition> discountConditions) {
    this.discountConditions = discountConditions;
  }

  public Money getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Money discountAmount) {
    this.discountAmount = discountAmount;
  }

  public double getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }
}
