package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 코드 안에서 선언된 참조 타입과 무관하게 실제로 메시지를 수신하는 객체의 타입에 따라 실행되는 메서드가 달라질 수 있는 것은 업캐스팅과 동적 바인딩이라는 매커니즘이 작용하기 떄문이다.
 * 업캐스팅: 부모 클래스 타입으로 선언된 변수에 자식 클래스의 인스턴스를 할당하는 것이 가능하다
 * 동적 바인딩: 선언된 변수의 타입이 아니라 메시지를 수신하는 객체의 타입에 따라 실행되는 메서드가 결정된다 -> 객체지향 시스템이 메시지를 처리할 적절한 메서드를 컴파일 시점이 아니라 실행 시점에 결정하기 떄문에 가능하다.
 * 동일한 수신자에게 동일한 메시지를 전송하는 동일한 코드를 이용해 서로 다른 메서드를 실행할 수 있는 이유는 업캐스팅과 동적 메서드 탐색이라는 기반 메커니즘이 존재하기 때문이다.
 * 업캐스팅은 서로 다른 클래스의 인스턴스를 동일한 타입에 할당하는 것을 가능하게 해준다. -> 부모 클래스에 대해 작성된 코드를 전혀 수정하지 않고도 자식 클래스에 적용 가능
 * 동적 메서드 탐색은 부모 클래스의 타입에 대해 메시지를 전송하더라도 실행시에는 실제 클래스를 기반으로 실행될 메서드가 선택되게 해준다 -> 코드를 변경하지 않고도 실행되는 메서드 변경 가능
 *
 * 업캐스팅
 * 부모 클래스의 인스턴스 대신 자식 클래스의 인스턴스를 사용하더라도 메시지를 처리하는 데는 아무런 문제가 없으며, 컴파일러는 명시적인 타입 변환 없이도 자식 클래스가 부모 클래스를 대체할 수 있게 허용한다.
 * 특성을 활용할 수 있는 대표적인 두가지가 대입문과 메서드의 파라미터 타입이다.
 * 모든 객체지향 언어는 명시적으로 타입을 변환하지 않고도 부모 클래스 타입의 참조 변수에 자식 클래스의 인스턴스를 대입할 수 있게 허용한다.
 * 반대로 부모 클래스의 인스턴스를 자식 클래스 타입으로 변환하기 위해서는 명시적인 타입 캐스팅이 필요한데 이를 다운캐스팅이라고 부른다.
 * 컴파일러의 관점에서 자식 클래스는 아무런 제약 없이 부모 클래스를 대체할 수 있기 때문에 부모 클래스와 협력하는 클라이언트는 다양한 자식 클래스의 인스턴스와도 협력하는 것이 가능하다.
 * 자식 클래스는 현재 상속 계층에 존재하는 자식 클래스뿐만 아니라 앞으로 추가될지도 모르는 미래의 자식 클래스들을 포함한다.
 * Lecture의 모든 자식 클래스는 evaluate 메시지를 이해할 수 있기 때문에 Professor는 Lecture를 상속받는 어떤 자식 클래스와도 협력할 수 있는 무한한 확장 가능성을 가진다.
 *
 * 동적 바인딩
 * 함수 호출과 메시지 전송 사이의 차이는 생각보다 큰데, 프로그램 안에 작성된 함수 호출 구문과 실제로 실행되는 코드를 연결하는 언어적인 메커니즘이 완전히 다르기 때문이다.
 * 함수를 호출하는 전통적인 언어들은 호출될 함수를 컴파일타임에 결정한다.
 * -> 컴파일 타임에 호출할 함수를 결정하는 방식을 정적 바인딩, 초기 바인딩, 컴파일타임 바인딩이라고 부른다.
 * 객체지향 언어에서는 메시지를 수신했을 때 실행될 메서드가 런타임에 결정된다.
 * -> 실행될 메서드를 런타임에 결정하는 방식을 동적 바인딩, 지연 바인딩이라고 부른다.
 * 객체지향 언어가 제공하는 업캐스팅과 동적 바인딩을 이용하면 부모 클래스 참조에 대한 메시지 전송을 자식 클래스에 대한 메서드 호출로 변환할 수 있다.
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }
}
