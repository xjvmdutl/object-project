package com.gmarket.objectproject.class_evaluation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

  private int pass;
  private String title;
  private List<Integer> scores = new ArrayList<>();

  public Lecture(String title, int pass, List<Integer> scores) {
    this.pass = pass;
    this.title = title;
    this.scores = scores;
  }

  public double average() {
    return scores.stream()
        .mapToInt(Integer::intValue)
        .average().orElse(0);
  }

  public List<Integer> getScores() {
    return Collections.unmodifiableList(scores);
  }

  public String evaluate() {
    return String.format("Pass:%d Fail:%d", passCount(), failCount());
  }

  private long passCount() {
    return scores.stream().filter(score -> score >= pass).count();
  }

  private long failCount() {
    return scores.size() - passCount();
  }

  public String stats(){
    return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());//현재 객체에게 getEvaluationMethod 메시지를 전송하는것이다.
    //현재 클래스의 메서드를 호출하는 것이 아닌 현재 객체에게 메시지를 전송하는 것이다. -> 여기서 현재는 self 참조가 가리키는 객체이다.
    //self 참조가 가리키는 자기 자신에게 메시지를 전송하는 것을 self 전송이라고 부른다.
    //self 전송을 이해하기 위해서는 self 참조가 가리키는 바로 그 객체에서부터 메시지 탐색을 다시 시작한다는 사실을 기억하자!!

  }


  public String getEvaluationMethod() {
    return "Pass or Fail";
  }
}
