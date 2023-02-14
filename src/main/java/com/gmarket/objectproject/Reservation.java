package com.gmarket.objectproject;

/**
 * 객체는 다른 객체의 인터페이스에 공개된 행동을 수행하도록 요청 할 수 있고, 요청을 받은 객체는 자율적인 방법에 따라 요청을 처리한 후 응답한다.
 * 객체가 다른 객체와 상호작용 하는 유일한 방법은 메시지를 전송하는 것 뿐이며, 다른 객체에게 요청이 도착할 때 해당 객체가 메시지를 수신 했다고 이야기 한다.
 * 메시지를 수신한 객체는 자율적으로 메시지를 처리할 방법을 결정하며, 처리할 방법을 메서드라고 한다,
 *
 */
public class Reservation {

  private Customer customer;
  private Screening screening;
  private Money money;
  private int audienceCount;

  public Reservation(Customer customer, Screening screening, Money money, int audienceCount){
    this.customer = customer;
    this.screening = screening;
    this.money = money;
    this.audienceCount = audienceCount;
  }
}
