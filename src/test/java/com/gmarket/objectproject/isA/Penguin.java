package com.gmarket.objectproject.isA;

public class Penguin extends Bird{

  /*
  @Override
  public void fly() {
    System.out.println("I Don't Fly");
  }
   */

  /**
   * 첫번째 방법: Penguin의 fly 메서드를 오버라이딩 해서 비워둔다.
   * Penguin에게 fly 메서드를 전달해도 아무일도 일어나지 않는다. 따라서 Penguin은 날 수 없게 된다.
   * 하지만 이 방법은 어떤 행동도 수행하지 않기 때문에 모든 bird가 날 수 있다는 클라이언트의 기대를 만족시키지 못한다 -> 올바른 설계라고 할 수 없다
   * 이 설계에서 Penguin과 Bird의 행동은 호환되지 않기 때문에 올바른 타입 계층이라고 할 수 없다.
   */
  /*
  @Override
  public void fly() {

  }
   */
  /**
   * 두번째 방법: Penguin의 fly 메서드를 오버라이딩한 후 예외를 던지게 하는 것이다.
   * 하지만 이 경우네는 flyBird 메서드에 전달되는 인자의 타입에 따라 메서드가 실패하거나 성공하게 된다.
   * flyBird 메서드는 fly 메시지를 전송한 결과로 UnsupportedOperationException 예외가 던져질 것이라고는 기대하지 않았을 것이다.
   */
  /*
  @Override
  public void fly() {
    throw new UnsupportedOperationException();
  }
   */
}
