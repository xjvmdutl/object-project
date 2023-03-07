package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 도메인의 구조가 코드를 이끈다
 * 구현을 가이드할 수 있는 도메인 모델을 선택해라
 *
 * 변경과 유연성
 * 할인 정책을 구현하기 위해 상속을 이용하고 있기 때문에 실행 중에 영화의 할인 정책을 변경하기 위해서는 새로운 인스턴스를 생성한 후 필요한 정보를 복사해야 한다.
 * 또한 변경 전후의 인스턴스가 개념적으로는 동일한 객체를 가리키지만 물리적으로는 서로 다른 객체이기 떄문에 식별자의 관점에서 혼란스러울 수 있다.
 * 새로운 할인 정책이 추가 될때마다 인스턴스를 생성하고 상태를 복사하고 식별자를 관리하는 코드를 추가하는 일은 변거로울뿐만 아니라 오류가 발생하기도 쉽다.
 * 이 경우 코드 복잡성이 올라가더라도 할인 정책의 변경을 쉽게 수용할 수 있도록 코드를 유연하게 만드는 것이 더 좋은 방법이며, 상속대신 합성을 사용하면 된다.
 * 유연성은 의존성 관리의 문제다. 요소들 사이의 의존성의 정도가 유연성의 정도를 결정한다.
 * 도메인 모델은 단순히 개념과 관계를 모아둔 것이 아닌 구현과 밀접한 관계를 가져야한다.
 * -> 코드에 대한 가이드를 제공할 수 있어야하며 코드의 변화에 발맞춰 함께 변화해야한다.
 *
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
