package com.gmarket.objectproject.salary;

import static com.gmarket.objectproject.salary.Salary.sumOfBasePays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SalaryMain {

  public static void main(String[] args) {
    String operation = "basePays";
    switch (operation) {
      case "pay":
        calculatePay("직원C");
        break;
      case "basePays": //새로운 정상급 함수가 추가될 때마다 main 함수의 내부를 수정해야한다.
        sumOfBasePays();
        break;
    }
  }

  private static void calculatePay(String name) {
    double taxRate = getTaxRate();
    double pay = Salary.calculatePay(name, taxRate);
    System.out.println(describeResult(name, pay));
  }

  private static double getTaxRate() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("세율을 입력하세요: ");
    try {
      return Double.parseDouble(reader.readLine());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  private static String describeResult(String name, double pay) {
    return "이름: " + name + ", 급여: " + pay;
  }

  private static void sumOfBasePays() {
    System.out.println(Salary.sumOfBasePays());
  }
}
