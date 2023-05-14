package com.gmarket.objectproject.phone_bill;

import java.time.Duration;
import java.time.LocalDateTime;

public class Client {

  public static void main(String[] args) {
    Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10), 1.5);
    phone.call(
        new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
            LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
    phone.call(
        new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
            LocalDateTime.of(2018, 1, 2, 12, 11, 0)));
    Money result = phone.calculateFee();//Money.wons(60)
    System.out.println(result);
   }
}
