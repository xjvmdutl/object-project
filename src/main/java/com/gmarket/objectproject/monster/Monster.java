package com.gmarket.objectproject.monster;

/*

public abstract class Monster {

private int health;

public Monster(int health) {
  this.health = health;
}

abstract public String getAttack();

}
 */
public class Monster {

  private int health;
  private Breed breed;

  public Monster(Breed breed) {
    this.breed = breed;
  }

  public String getAttack() {
    return breed.getAttack();
  }
}