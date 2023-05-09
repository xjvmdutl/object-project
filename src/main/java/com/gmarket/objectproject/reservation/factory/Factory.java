package com.gmarket.objectproject.reservation.factory;

import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Movie;
import com.gmarket.objectproject.reservation.pricing.AmountDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.SequenceCondition;
import java.time.Duration;

public class Factory {

  public Movie createAvatarMovie() {
    return new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000));
  }
}
