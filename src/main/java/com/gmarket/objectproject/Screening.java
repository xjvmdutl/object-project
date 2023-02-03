package com.gmarket.objectproject;

import java.time.LocalDateTime;

public class Screening {
  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
    this.movie = movie;
    this.sequence = sequence;
    this.whenScreened = whenScreened;
  }

  /**
   * 상영 시작 시간 반환
   * @return
   */
  public LocalDateTime getStartTime(){
    return whenScreened;
  }

  /**
   * 순번의 일치 여부를 검사
   * @param sequence
   * @return
   */
  public boolean isSequence(int sequence){
    return this.sequence == sequence;
  }


  /**
   * 기본요금을 반환
   * @return
   */
  public Money getMovieFee(){
    return movie.getFee();
  }


  public Reservation reserve(Customer customer, int audienceCount){
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }
}
