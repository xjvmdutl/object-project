package com.gmarket.objectproject;

import java.time.LocalDateTime;

public class Screening {
  //인스턴스 변수 결정
  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  public Reservation reserve(Customer customer, int audienceCount) { //메시지
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
    //수신자인 movie가 아니라 송신자인 screening의 의도를 표현
    //Screening이 Movie의 내부 구현에 대한 어떤 지식도 없이 전송할 메시지를 결정했다 -> Movie 구현을 고려하지 않고 필요한 메시지를 결정하면 movie 내부 구현을 깔끔하게 캡슐화 할 수 있다.
    //이처럼 메시지가 객체를 선택하도록 책임 주도 설계의 방식을 따르면 캡슐화와 낮은 결합도라는 목표를 비교적 손쉽게 달성할 수 있다.
  }

  public LocalDateTime getWhenScreened() {
    return whenScreened;
  }

  public int getSequence() {
    return sequence;
  }
}
