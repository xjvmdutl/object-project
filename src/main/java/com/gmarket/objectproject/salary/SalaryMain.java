package com.gmarket.objectproject.salary;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalaryMain {

  private static List<Employee> employees = new ArrayList<>() {
    {
      add(new SalariedEmployee("직원A", 400));
      add(new SalariedEmployee("직원B", 300));
      add(new SalariedEmployee("직원C", 250));
      add(new HourlyEmployee("아르바이트D", 1, 120));
      add(new HourlyEmployee("아르바이트E", 1, 120));
      add(new HourlyEmployee("아르바이트F", 1, 120));
    }
  };

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
    Employee em = null;
    double taxRate = getTaxRate();
    for (Employee employee : employees) {
      if (employee.getName().equals(name)) {
        em = employee;
      }
      break;
    }
    double pay = em.calculatePay(taxRate);
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
    int result = 0;
    for (Employee employee : employees) {
      result += employee.monthlyBasePay();
    }
    System.out.println(result);
  }
}
