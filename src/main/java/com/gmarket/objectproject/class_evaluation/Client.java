package com.gmarket.objectproject.class_evaluation;

import java.util.Arrays;

public class Client {

  public static void main(String[] args) {
    /*
    Lecture parent = new Lecture("알고리즘", 70, Arrays.asList(81, 95, 75, 50, 45));
    parent.evaluate();//Leature 클래스 안에 evaluate 메서드가 존재하기 때문에 시스템은 메서드를 실행한 후 메서드 탐색을 종료한다.
    GradeLecture child = new GradeLecture("알고리즘", 70,
        Arrays.asList(
            new Grade("A", 100, 95),
            new Grade("B", 94, 80),
            new Grade("C", 79, 70),
            new Grade("D", 69, 50),
            new Grade("F", 49, 0)),
        Arrays.asList(81, 95, 75, 50, 45));
      child.evaluate(); // 실제 객체를 생성한 클래스인 GradeLecture 에 정의된 메서드가 실행된다.
     */
    /**
     * 동적 메서드 탐색은 self 참조가 가리키는 객체의 클래스인 GradeLecture에서 시작되고 GradeLecture 클래스 안에 evaluate 메서드가 구현되어 있기 때문에 먼저 발견된 메서드가 실행되는 것이다.
     * 자식 클래스와 부모 클래스 양쪽 모두에 동일한 시그니처를 가진 메서드가 구현돼 있다면 자식 클래스의 메서드가 먼저 검색된다.
     * 자식 클래스가 부모 클래스의 메서드를 오버라이딩하면 자식 클래스에서 부모 클래스로 향하는 메서드 탐색 순서 때문에 자식 클래스의 메서드가 부모 클래스의 메서드를 감추게 된다.
     */
    GradeLecture child = new GradeLecture("알고리즘", 70,
        Arrays.asList(
            new Grade("A", 100, 95),
            new Grade("B", 94, 80),
            new Grade("C", 79, 70),
            new Grade("D", 69, 50),
            new Grade("F", 49, 0)),
        Arrays.asList(81, 95, 75, 50, 45));
    child.average("A");//average 메서드를 GradeLecture에서 발견할 수 있기 때문에 동적 메서드 탐색은 탐색이 시작되는 첫 번째 클래스인 GradeLecture에서 종료된다.
    Lecture parent = new GradeLecture("알고리즘", 70,
        Arrays.asList(
            new Grade("A", 100, 95),
            new Grade("B", 94, 80),
            new Grade("C", 79, 70),
            new Grade("D", 69, 50),
            new Grade("F", 49, 0)),
        Arrays.asList(81, 95, 75, 50, 45));
    parent.average(); //GradeLecture 클래스 안에서 메시지에 응답할 수 있는 적절한 메서드를 발견하지 못하기 때문에 부모 클래스인 Lecture 클래스에서 메서드를 찾으려고 시도한다.
    /**
     * 메서드 오버라이딩은 자식 클래스가 부모 클래스에 존재하는 메서드와 동일한 시그니처를 가진 메서드를 재정의해서 부모 클래스의 메서드를 감추는 현상을 가리킨다 -> 단, average(), average(String gradeName)은 메서드 이름은 같지만 시그니처가 다르다.
     * 시그니처가 다르기 때문에 동일한 이름의 메서드가 공존하는 경우를  메서드 오버로딩이라고 부른다. -> 메서드 오버라이딩은 메서드를 감추지만, 메서드 오버로딩은 사이좋게 공존한다.
     * 일부 언어에서는 상속 계층 사이의 메서드 오버로딩을 지원하지 않는다(c++) -> C++에서는 부모 클래스의 메서드와 동일한 이름의 메서드를 자식 클래스에서 오버로딩하면 그 이름을 가진 모든 부모 클래스의 메서드를 감춰 버린다.
     * c++은 같은 클래스 안에서의 메서드 오버로딩은 허용하지만 자바와 달리 상속 계층 사이에서의 메서드 오버로딩은 금지한다.
     * 이름 숨기기: 상속 계층 안에서 동일한 이름을 가진 메서드가 공존해서 발생하는 혼란을 방지하기 위해 부모 클래스에 선언된 이름이 동일한 메서드 전체를 숨겨서 클라이언트가 호출하지 못하도록 막는다.
     * 요점은 동적 메서드 탐색과 관련된 규칙이 언어마다 다를 수 있다는 점이다.
     */
    child.stats(); //Lecture 인스턴스가 stats 메시지를 수신하면 self 참조는 Leture 인스턴스를 가리키도록 자동으로 할당이 되고 이 객체의 클래스인 Lecture에서 메서드를 발견하고 이를 실행시킨다.
    //self가 참조하는 현재 객체에 getEvaluationMethod 메시지를 전송하라는 의미인 것이다. -> 메서드 탐색은 처음에 메시지 탐색을 시작했던 self 참조가 가리키는 바로 그 클래스에서부터 다시 시작한다는 것이다.
    System.out.println(parent.stats()); //Grade 출력
    // Leture 클래스의 stats 메서드를 실행하는 중에 self 참조가 가리키는 객체에게 getEvaluationMethod 메시지를 전송하는 구문과 마주치게 된다.
    // 이제 메서드 탐색은 self 참조가 가리키는 객체에서 시작하게 되는데, 여기서 self 참조가 가리키는 객체는 바로 GradeLeture의 인스턴스이다. -> 메시지 탐색이 self가 가리키는 GradeLeture 에서부터 다시 시작된다.
    // 따라서 시스템은 GradeLeture의 getEvaluationMethod 메서드를 발견하고 실행한 후 동적 메서드 탐색을 종료한다.
    //self 전송은 자식 클래스에서 부모 클래스 방향으로 진행되는 동적 메서드 탐색 경로를 다시 self 참조가 가리키는 원래의 자식 클래스로 이동시킨다.
    //이로 인해 최악의 경우에는 실제로 실행될 메서드를 이해하기 위해 상속 계층 전체를 훑어가며 코드를 이해해야 하는 상황이 발생할 수도 있다.
    //결과적으로 self 전송이 깊은 상속 계층과 계층 중간중간에 함정처럼 숨겨져 있는 메서드 오버라이딩과 만나면 극단적으로 이해하기 어려운 코드가 만들어 진다.
  }
}
