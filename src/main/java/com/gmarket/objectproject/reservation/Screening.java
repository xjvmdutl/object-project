package com.gmarket.objectproject.reservation;

import java.time.LocalDateTime;

public class Screening {

  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  /**
   * Contract.invariant() 메서드를 이용해 불변식을 정의할 수 있다. 불변식은 생성자 실행 후, 메서드 실행 전, 메서드 실행후에 호출돼야 한다는 점을 기억하자
   * ContractInvariantMethod 에트리뷰트가 지정된 메서드를 불변식을 체크해야 하는 모든 지점에 자동으로 추가한다.
   */
  /**
    [ContractInvariantMethod]
    private void Invariant(){
     Contract.invariant(movie != null);
     Contract.invariant(sequence >= 1);
     Contract.invariant(whenScreened > DateTime.Now);
    }
   */

  public Reservation reserve(Customer customer, int audienceCount) { //메시지
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  public Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }

  public LocalDateTime getWhenScreened() {
    return whenScreened;
  }

  public int getSequence() {
    return sequence;
  }

  public Movie getMovie() {
    return movie;
  }
}
