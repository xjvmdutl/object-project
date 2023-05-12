package com.gmarket.objectproject.reservation.factory;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Movie;
import com.gmarket.objectproject.reservation.Screening;
import com.gmarket.objectproject.reservation.ServiceLocator;
import com.gmarket.objectproject.reservation.pricing.AmountDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.PercentDiscountPolicy;
import com.gmarket.objectproject.reservation.pricing.SequenceCondition;
import java.time.Duration;
import java.time.LocalDateTime;

public class Client {

  private Factory factory;

  public Client(Factory factory) {
    this.factory = factory;
  }

  public Money getAvatarFee() {
    ServiceLocator.provide(new PercentDiscountPolicy(0.1,new SequenceCondition(10)));
    Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000));
    return avatar.getFee();
  }
}
