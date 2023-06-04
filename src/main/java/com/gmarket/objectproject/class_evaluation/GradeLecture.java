package com.gmarket.objectproject.class_evaluation;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class GradeLecture extends Lecture {

  private List<Grade> grades;

  public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
    super(title, pass, scores);//super는 자식 클래스 내부에서 부모 클래스의 인스턴스 변수나 메서드에 접근하는데 사용된다.
    this.grades = grades;
  }

  @Override
  public String evaluate() {
    return super.evaluate() + ", " + gradesStatistics();
  }

  private String gradesStatistics() {
    return grades.stream().map(grade -> format(grade)).collect(joining(" "));
  }

  private String format(Grade grade) {
    return String.format("%s:%d", grade.getName(), gradeCount(grade));
  }

  private long gradeCount(Grade grade) {
    return getScores().stream().filter(grade::include).count();
  }

  public double average(String gradeName) {
    return grades.stream().filter(each -> each.isName(gradeName)).findFirst()
        .map(this::gradeAverage).orElse(0d);
  }

  private double gradeAverage(Grade grade) {
    return getScores().stream().filter(grade::include).mapToInt(Integer::intValue).average()
        .orElse(0);
  }

  @Override
  public String getEvaluationMethod() {
    return "Grade"; //오버라이딩
  }

}
