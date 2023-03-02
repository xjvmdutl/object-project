package com.gmarket.objectproject;

public class AnyClass {

  /**
   * 사각형의 너비와 높이를 증가시키는 코드이다
   * 문제점
   * 1) 코드 중복이 발생할 확률이 높다(다른 곳에서도 사각형의 너비와 높이를 증가시키는 코드가 필요하다면, getRight(), getBottom() 을 호출하여 값을 가지고 오는 코드가 중복될 것이다)
   * 2) 변경에 취약하다( 내부 인스턴스 변수의 존재 사실을 인터페이스를 통해 외부로 노출시키기 때문에, 인스턴스 변수의 변경은 기존의 접근자 메서드를 사용하던 모든 코드에 영향을 미친다.)
   * -> 캡슐화를 강화시키면 해당 문제를 모두 해결할 수 있다.
   *
   */
  void anyMethod(Rectangle rectangle, int multiple) {
    rectangle.setRight(rectangle.getRight() * multiple);
    rectangle.setBottom(rectangle.getBottom() * multiple);
  }
}
