package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 계약에 의한 설계는 클라이언트가 만족시켜야 하는 사전조건과 클라이언트의 관점에서 서버가 만족시켜야 하는 관점에서 서버가 만족시켜야 하는 사후조건을 기술한다.
 * 리스코픈 치환 원칙은 슈퍼타입의 인스턴스와 협력하는 클라이언트의 관점에서 서브타입의 인스턴스가 슈퍼타입을 대체하더라도 협력에 지장이 없어야 한다는 것을 의미하낟.
 * - 서브 타입이 리스코프 치환 원칙을 만족시키기 위해서는 클라이언트와 슈퍼타입 간에 체결된 계약을 준수해야한다.
 * 리스코프 치환 원칙의 규칙: 1)협력에 참여하는 객체에 대한 기대를 표현하는 계약 규칙 2) 교체 가능한 타입과 관련된 가변성 규칙
 * 계약 규칙: 슈퍼타입과 서브타입 사이의 사전조건, 사후조건, 불변식에 대해 서술할 수 있는 제약에 관한 규칙
 * - 서브타입에 더 강력한 사전조건을 정의할 수 없다.
 * - 서브타입에 더 완화된 사후조건을 정의할 수 없다.
 * - 슈퍼타입의 불변식은 서브타입에서도 반드시 유지되야 한다.
 * 가변성 규칙: 파라미터와 리턴 타입의 변형과 관련된 규칙
 * - 서브타입의 메서드 파라미터는 반공변성을 가져야한다.
 * - 서브타입의 리턴 타입은 공변성을 가져야 한다.
 * - 서브타입은 슈퍼타입이 발생시키는 예외와 다른 타입의 예외를 발생시켜서는 안된다.
 *
 * 계약 규칙
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }
}
