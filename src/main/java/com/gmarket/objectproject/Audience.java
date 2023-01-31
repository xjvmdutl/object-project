package com.gmarket.objectproject;

public class Audience {
  private Bag bag;

  public Audience(Bag bag){
    this.bag = bag;
  }

  public Long buy(Ticket ticket){
    //자신의 가방안에 초대장이 있는지 스스로 확인
    //외부에서 더이상 Audience가 Bag을 소유하고 있다는 사실을 알 필요가 없다
    return bag.hold(ticket);
  }
}
