package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 객체지향 설계에서의 객체 분할 방법
 * 1) 상태를 분할의 중심축으로 삼는 방식
 * 2) 책임을 분할의 중심축으로 삼는 방식
 * 상태 중심 관점에서 객체는 자신이 포함하고 있는 데이터를 조작하는데 필요한 오퍼레이션을 정의한다
 * 책임 중심 관점에서 객체는 다른 객체가 요청할 수 있는 오퍼레이션을 위해 필요한 상태를 보관한다.
 * 훌룡한 객체지향 설계는 책임에 초점을 맞춰야한다.
 * -> 객체의 상태는 구현에 속하며 구현은 불안정하여 변경이 쉽다. 따라서 상태를 객체분할의 중심축으로 삼으면 구현에 관한 세부사항이 객체의 인터페이스에 스며들게 되어 캡슐화의 원칙이 무너진다.
 * 결과적으로 상태 변경은 인터페이스의 변경을 초래하며 이 인터페이스에 의존하는 모든 객체에게 변경의 영향이 퍼지게 된다.
 * 객체의 책임은 인터페이스에 속하며 객체는 책임의 드러내는 안정적인 인터페이스 뒤로 책임을 수행하는 데 필요한 상태를 캡슐화함으로써 구현 변경에 대한 파장이 외부로 퍼져나가는 것을 방지한다.
 *
 * 데이터를 준비하자
 * 데이터 중심의 설계란 객체 내부에 저장되는 데이터를 기반으로 시스템을 분할하는 방법이다.
 * 데이터 중심의 설계는 객체가 내부에 저장해야 하는 데이터가 무엇인가 묻는 것 으로 시작한다.
 * 데이터 중심의 설계에서는 객체가 포함해야 하는 데이터에 집중한다. 객체의 책임을 결정하기 전에 "이 객체가 포함해야 하는 데이터는 무엇인가?" 질문의 반복에 휩쓸려 있다면 데이터 중심의 설계에 매몰돼 있을 확률이 높다.
 *
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
