package com.gmarket.objectproject.class_evaluation;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture{

  public FormattedGradeLecture(String name, int pass, List<Grade> grades,
      List<Integer> scores) {
    super(name, pass, grades, scores);
  }


  public String formatAverage(){
    return String.format("Avg: %1.1f", super.average()); //부모 클래스를 실행하였다면 실행될 수 없다 -> GradeLecture가 아닌 Lecture에 정의되어 있기 때문
  }
}
