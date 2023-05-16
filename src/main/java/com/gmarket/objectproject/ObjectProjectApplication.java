package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 코드 중복을 제거하기 위해 상속을 도입할 때 따르는 2가지 원칙
 * - 두 메서드가 유사하게 보인다면 차이점을 메서드로 추출하라. 메서드 춫출을 통해 두 메서드를 동일한 형태로 보이도록 만들 수 있다.
 * - 부모 클래스의 코드를 하위로 내리지 말고 자식 클래스의 코드를 상위로 올려라. 부모 클래스의 구체적인 메서드를 자식 클래스로 내리는 것보다 자식 클래스의 추상적인 메서드를 부모 클래스로 올리는 것이 재사용성과 응집도 측면에서 더 뛰어난 결과를 얻는다.
 *
 * 차이를 메서드로 추출하라
 * "변하는 것으로부터 변하지 않는 것을 분리하라", "변하는 부분을 찾고 이를 캡슐화하라"라는 조언을 메서드 수준에서 적용한 것이다.
 *
 * 추상화가 핵심이다
 * 공통 코드를 이동시킨 후에 각 클래스는  서로 다른 변경의 이유를 가진다는 것에 주목하라(각각의 클래스는 각각 하나의 이유만을 가진다) -> 단일 책임 원칙을 준수하므로 응집도가 높다
 * 변경 전에는 자식 클래스가 부모 클래스의 구현에 강하게 결합되어 부모 클래스 구현을 변경하면 자식클래스도 함께 영향을 받았지만, 변경 후엔 자식 클래스는 오직 추상화에 의존하기 때문에 메서드의 시그니처가 변경되진 않는한 부모 클래스 변경이 자식클래스에 영향을 주지 않는다.
 * 부모 클래스는 추상화에 의존하고 의존성 역전 원칙, 개방-폐쇄의 원칙도 준수한다. -> 새로운 요금제를 추가하기도 쉽다.
 *
 * 의도를 드러내는 이름 선택하기
 * 클래스의 이름과 관련된 부분이 아쉽기 때문에 AbstractPhone -> Phone으로 Phone -> RegularPhone으로 변경하여 의도를 명확히 하자
 *

 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }
}
