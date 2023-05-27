package com.gmarket.objectproject.phone_bill.additional;

import com.gmarket.objectproject.phone_bill.AdditionalRatePolicy;
import com.gmarket.objectproject.phone_bill.Money;
import com.gmarket.objectproject.phone_bill.RatePolicy;

public class TaxablePolicy extends AdditionalRatePolicy {

  private double taxRatio;

  public TaxablePolicy(double taxRatio, RatePolicy next) {
    super(next);
    this.taxRatio = taxRatio;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRatio));
  }
}
