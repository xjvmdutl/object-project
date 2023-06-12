package com.gmarket.objectproject.game;

public interface Collidable extends Displayable { //자동적으로 GetObject 타입의 서브객체가 된다.

  boolean collideWith(Collidable other);
}
