package com.gmarket.objectproject.phone_bill;

import com.gmarket.objectproject.phone_bill.additional.RateDiscountablePolicy;
import com.gmarket.objectproject.phone_bill.additional.TaxablePolicy;
import com.gmarket.objectproject.phone_bill.basic.NightlyDiscountPolicy;
import com.gmarket.objectproject.phone_bill.basic.RegularPolicy;
import java.time.Duration;

public class Client {

  public static void main(String[] args) {
    Phone basicPhone = new Phone(
        new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
    Phone nightlyPhone = new Phone(
        new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));

    Phone taxableBasicPhone = new Phone(
        new TaxablePolicy(0.05,
            new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));
    Phone taxableAndRateDiscountBasicPhone = new Phone(
        new TaxablePolicy(0.05,
            new RateDiscountablePolicy(Money.wons(1000),
                new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
    Phone RateDiscountAndTaxableBasicPhone = new Phone(
        new RateDiscountablePolicy(Money.wons(1000),
            new TaxablePolicy(0.05, new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))));
    Phone RateDiscountAndTaxableNightlyPhone = new Phone(
        new RateDiscountablePolicy(Money.wons(1000),
            new TaxablePolicy(0.05,
                new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)))));
  }
}
