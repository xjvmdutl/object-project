package com.gmarket.objectproject.dock;

import com.gmarket.objectproject.phone.Money;

public class Client {
  public static void main(String[] args) {
    Client client = new Client();
    //컴파일 오류
    //client.calculate(new SalariedEmployee("test", Money.wons(1000)));
    //client.calculate(new HourlyEmployee("test", Money.wons(1000), 10));
  }

  private Money calculate(Employee employee, double taxRate) {
    return employee.calculatePay(taxRate);
  }
}
