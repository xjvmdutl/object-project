package com.gmarket.objectproject.reservation.pricing;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Screening;

public class SequenceCondition implements DiscountCondition {
  private int sequence;

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }

}
