package com.gmarket.objectproject.salary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Salary {
  private static List<String> employees = new ArrayList<>(
      Arrays.asList("직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"));
  private static double[] basePays = new double[]{400, 300, 250, 1, 1, 1.5};

  private static boolean[] hourlys = new boolean[]{false, false, false, true, true, true};
  private static int[] timeCards = new int[]{0, 0, 0, 120, 120, 120};


  public static double calculatePay(String name, double taxRate) {
    double pay;
    if (isHourly(name)) {
      pay = calculateHourlyPayFor(name, taxRate);
    } else {
      pay = calculatePayFor(name, taxRate);
    }
    return pay;
  }


  private static boolean isHourly(String name) {
    return hourlys[employees.indexOf(name)];
  }

  private static double calculateHourlyPayFor(String name, double taxRate) {
    int index = employees.indexOf(name);
    double basePay = basePays[index] * timeCards[index];
    return basePay - (basePay * taxRate);
  }
  public static int sumOfBasePays() {
    int result = 0;
    for (String name : employees) {
      if(!isHourly(name)){
        result += basePays[employees.indexOf(name)];
      }
    }
    return result;
  }




  private static double calculatePayFor(String name, double taxRate) {
    int index = employees.indexOf(name);
    double basePay = basePays[index];
    return basePay - (basePay * taxRate);
  }


}
