package com.gmarket.objectproject;

public class SequenceCondition implements DiscountCondition{
  private int sequence; //할인 여부 판단

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence); //상영 순번과 일치하는지 판단.
  }
}
