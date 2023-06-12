package com.gmarket.objectproject.game.impl;

import com.gmarket.objectproject.game.Collidable;
import com.gmarket.objectproject.game.Graphics;
import com.gmarket.objectproject.game.Point;

/**
 * 자바와 C#에서는 인터페이스를 이용해 타입의 퍼블릭 인터페이스를 정의하고 클래스를 이용해 객체를 구현하는 것이 일반적인 패턴이다.
 * 인터페이스와 클래스를 함께 조합하면 다중 상속의 딜레마에 빠지지 않을 수 있고 단일 상속 계층으로 인한 결합도 문제도 피할 수 있다.
 */
public class Player implements Collidable {

  @Override
  public boolean collideWith(Collidable other) {
    return false;
  }

  @Override
  public Point getPosition() {
    return null;
  }

  @Override
  public void update(Graphics graphics) {

  }

  @Override
  public String getName() {
    return null;
  }
}
