package com.gmarket.objectproject.game.impl;

import com.gmarket.objectproject.game.Collidable;
import com.gmarket.objectproject.game.Graphics;
import com.gmarket.objectproject.game.Point;

public class Monster implements Collidable {

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
