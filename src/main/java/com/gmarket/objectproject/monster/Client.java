package com.gmarket.objectproject.monster;

public class Client {

  public static void main(String[] args) {
    /**
     * 새로운 클래스를 추가하는 대신 Breed의 새로운 인스턴스를 생성하는 것으로 타입 추가 문제를 해결했다.
     * 새로운 클래스를 추가해야 하는 작업을 인스턴스 생성으로 대체한 것과 동일하다.
     * 타입의 표현하는 클래스의 인스턴스로 구현이 되었으며, 어떤 객체의 타입을 표현하는 별도의 객체를 이용해 타입을 구현하는 것이다.
     * 어떤 인스턴스가 다른 인스턴스의 타입을 표현하는 방법을 Type Object 패턴이라고 부른다.
     */
    Monster dragon = new Monster(new Breed("용", 230, "용은 불을 내뿜는다."));
    Monster troll = new Monster(new Breed("트롤", 48, "트롤은 곤봉으로 떄린다."));
  }
}
