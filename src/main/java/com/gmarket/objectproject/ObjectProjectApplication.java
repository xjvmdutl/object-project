package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectProjectApplication {

  /**
   * 진정한 객체지향 패러다임으로의 전환은 클래스가 아닌 객체에 초점을 맞출 때 얻을 수 있으며 아래 2가지에 초점을 맞춰야 한다
   * 1) 어떤 클래스가 필요한지 고민하기 전에 어떤 객체들이 필요한지 고민하자(어떤 객체들이 어떤 상태와 행동을 가지는지를 먼저 결정)
   * 2) 객체는 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 보자(객체는 홀로 존재하지 않으며, 협력하고 의존하는 존재이다)
   *
   * 도메인 : 문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야
   * 일반적으로 클래스의 이름은 대응되는 도메인 개념의 이름과 동일하거나 유사하게 작성해야 한다(클래스 관계도 도메인과 유사하게 만들어 이해하기 쉽게 해야한다)
   *
   *
   */
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
