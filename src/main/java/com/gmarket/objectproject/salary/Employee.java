package com.gmarket.objectproject.salary;

public class Employee {
  private String name;
  private double basePay;
  private boolean hourly;
  private int timeCard;

  public String getName() {
    return name;
  }

  public Employee(String name, double basePay, boolean hourly, int timeCard) {
    this.name = name;
    this.basePay = basePay;
    this.hourly = hourly;
    this.timeCard = timeCard;
  }

  public double calculatePay(double taxRate) {
    if (hourly) {
      return calculateHourlyPayFor(taxRate);
    } else {
      return calculateSalariedPay(taxRate);
    }
  }
  private double calculateHourlyPayFor(double taxRate) {
    return (basePay * timeCard) - (basePay * timeCard) * taxRate;
  }
  private double calculateSalariedPay(double taxRate) {
    return basePay - (basePay * taxRate);
  }

  public double monthlyBasePay() {
    if (hourly) {
      return 0;
    } else {
      return basePay;
    }
  }
}
