package com.gmarket.objectproject.salary;

public abstract class Employee {
  protected String name;
  protected double basePay;

  public String getName() {
    return name;
  }

  public Employee(String name, double basePay) {
    this.name = name;
    this.basePay = basePay;
  }

  public abstract double calculatePay(double taxRate);

  public abstract double monthlyBasePay();

}
