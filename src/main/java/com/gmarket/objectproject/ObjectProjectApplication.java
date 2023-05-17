package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 기존 코드와 다른 부분만을 추가함으로써 애플리케이션의 기능을 확장하는 방법을 차이에 의한 프로그래밍이라고 부른다.
 * 상속을 이용하면 이미 존재하는 클래스이 코드를 쉽게 재사용할 수 있기 때문에 애플리케이션의 점진적인 정의가 가능해진다.
 * 차이에 의한 프로그래밍의 목표는 중복 코드를 제거하고 코드를 재사용하는 것이다. -> 중복코드를 제거하기 위해 최대한 코드를 재사용해야한다.
 * 재사용 가능한 코드란 심각한 버그가 존재하지 않는 코드로 객체지향에서 중복코드를 제거하고 코드를 재사용할 수 있는 가장 유명한 방법은 상속이다.
 * 상속을 이용하면 새로운 기능을 추가하기 위해 직접 구현해야 하는 코드의 양을 최소화할 수 있다.
 * 사람들은 코드를 재사용하기 위해 맹목적으로 상속을 사용하는 것이 위험하다는 사실을 깨닫기 시작했다. -> 상속의 오용과 남용은 애플리케이션을 이해하고 확장하기 어렵게 만든다.
 * 정말 필요한 경우 상속을 사용하자 -> 상속의 단점을 필하면서도 코드를 재사용할 수 있는 합성을 사용하자
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }
}
