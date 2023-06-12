package com.gmarket.objectproject.game;


public interface Displayable extends GameObject{ //GameObject를 확장 -> 인터페이스가 다른 인터페이스를 확장하도록 만들면 슈퍼 타입과 서브타입간의 타입 계층을 구성할 수 있다.
  Point getPosition();
  void update(Graphics graphics);
}
