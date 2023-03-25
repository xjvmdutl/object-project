package com.gmarket.objectproject.reservation;

public class ReservationAgency {
  public Reservation reservation(Screening screening, Customer customer, int audienceCount){
    Money fee = screening.calculateFee(audienceCount);
    return new Reservation(customer, screening, fee, audienceCount);
  }
}
