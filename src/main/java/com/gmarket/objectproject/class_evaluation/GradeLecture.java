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
    /**
     * 부모 클래스와 자식 클래스에 동일한 시그니처를 가진 메서드가 존재할 경우 자식 클래스의 메서드 우선순위가 더 높다. -> 메시지를 수신했을 때 부모 클래스의 메서드가 아닌 자식 클래스의 메서드가 실행된다는 것을 의미
     * 결과적으로 동일한 시그니처를 가진 자식 클래스의 메서드가 부모 클래스의 메서드를 가리게 된다.
     * 이처럼 자식 클래스 안에 상속받은 메서드와 동일한 시그니처의 메서드를 재정의해서 부모 클래스의 구현을 새로운 구현으로 대체하는 것을 메서드 오버라이딩이라고 부른다.
     */
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

  /**
   * 메서드는 같지만 시그니처가 다르다(두 메서드는 사이좋게 공존할 수 있다) -> 클라이언트가 두 메서드를 모두 호출할 수 있다.
   * 부모 클래스에서 정의한 메서드와 이름은 동일하지만 시그니처는 다른 메서드를 자식클래스에 추가하는 것을 메서드 오버로딩이라고 부른다.
   */
  public double average(String gradeName) {
    return grades.stream().filter(each -> each.isName(gradeName)).findFirst()
        .map(this::gradeAverage).orElse(0d);
  }

  private double gradeAverage(Grade grade) {
    return getScores().stream().filter(grade::include).mapToInt(Integer::intValue).average()
        .orElse(0);
  }
}
