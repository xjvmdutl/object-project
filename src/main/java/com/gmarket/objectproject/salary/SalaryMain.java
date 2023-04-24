package com.gmarket.objectproject.salary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalaryMain {

  private static List<String> employees = new ArrayList<>(
      Arrays.asList("직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"));
  private static double[] basePays = new double[]{400, 300, 250, 1, 1, 1.5};

  private static boolean[] hourlys = new boolean[]{false, false, false, true, true, true};
  private static int[] timeCards = new int[]{0, 0, 0, 120, 120, 120};

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
    double pay;
    if (isHourly(name)) {
      pay = calculateHourlyPayFor(name, taxRate);
    } else {
      pay = calculatePayFor(name, taxRate);
    }
    System.out.println(describeResult(name, pay));
  }


  private static boolean isHourly(String name) {
    return hourlys[employees.indexOf(name)];
  }

  private static double calculateHourlyPayFor(String name, double taxRate) {
    int index = employees.indexOf(name);
    double basePay = basePays[index] * timeCards[index];
    return basePay - (basePay * taxRate);
  }
  private static void sumOfBasePays() {
    int result = 0;
    for (String name : employees) {
      if(!isHourly(name)){
        result += basePays[employees.indexOf(name)];
      }
    }
    System.out.println(result);
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

  private static double calculatePayFor(String name, double taxRate) {
    int index = employees.indexOf(name);
    double basePay = basePays[index];
    return basePay - (basePay * taxRate);
  }

  private static String describeResult(String name, double pay) {
    return "이름: " + name + ", 급여: " + pay;
  }
}
