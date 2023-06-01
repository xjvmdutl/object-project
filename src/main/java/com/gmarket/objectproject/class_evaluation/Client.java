package com.gmarket.objectproject.class_evaluation;

import java.util.Arrays;

public class Client {

  public static void main(String[] args) {
    /*
    Professor professor = new Professor("다익스트라",
        new Lecture("알고리즘", 70, Arrays.asList(81, 95, 75, 50, 45)));

    String statistics = professor.compileStatistics();
    System.out.println(statistics);
     */
    Professor professor = new Professor("다익스트라",
        new GradeLecture("알고리즘", 70,
            //생성자의 인자 타입은 Lecture로 선언이 되어 있지만 GradeLecture 인스턴스를 전달하더라도 아무 문제 없이 실행된다.
            Arrays.asList(
                new Grade("A", 100, 95),
                new Grade("B", 94, 80),
                new Grade("C", 79, 70),
                new Grade("D", 69, 50),
                new Grade("F", 49, 0)),
            Arrays.asList(81, 95, 75, 50, 45)));
    String statistics = professor.compileStatistics();
    System.out.println(statistics);

    Lecture lecture = new GradeLecture("알고리즘", 70, //업캐스팅
        Arrays.asList(
            new Grade("A", 100, 95),
            new Grade("B", 94, 80),
            new Grade("C", 79, 70),
            new Grade("D", 69, 50),
            new Grade("F", 49, 0)),
        Arrays.asList(81, 95, 75, 50, 45));
    GradeLecture gradeLecture = (GradeLecture) lecture; //다운 캐스팅

  }
}
