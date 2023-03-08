package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 책임 주도 설계에 익숙해지기 위해서는 부단한 노력과 시간이 필요하다.
 * 책임과 객체 사이에서 방황할 때 돌파구를 찾기 위해 선택하는 방법은 최대한 빠르게 목적한 기능을 수행하는 코드를 작성하는 것이다.
 * 아무것도 없는 상태에서 책임과 협력에 관해 고민하기보다는 일단 실행되는 코드를 얻고 난 후에 코드 상에 명확하게 드러나는 책임들을 올바른 위치로 이동시키는 것이다.
 * 주의할 점은 코드를 수정한 후에 겉으로 드러나는 동작이 바뀌어서는 안된다는 것이다(캡슐화를 향상시키고, 응집도를 높이고, 결합도를 낮춰야 하지만 동작은 그대로 유지해야한다)
 * 리펙터링: 이해하기 쉽고 수정하기 쉬운 소프트웨어로 개선하기 위해 겉으로 보이는 동작은 바꾸지 않은 채 내부 구조를 변경하는 것
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
