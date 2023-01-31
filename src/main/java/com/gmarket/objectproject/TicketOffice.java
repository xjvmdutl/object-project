package com.gmarket.objectproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {

  private Long amount;
  private List<Ticket> tickets = new ArrayList<>();

  public TicketOffice(Long amount, Ticket... tickets) {
    this.amount = amount;
    this.tickets.addAll(Arrays.asList(tickets));
  }

  private Ticket getTicket() {
    return tickets.remove(0);
  }

  public void minusAmount(Long amount){
    this.amount -= amount;
  }

  private void plusAmount(Long amount){
    this.amount += amount;
  }


  public void sellTicketTo(Audience audience) {
    plusAmount(audience.buy(getTicket()));
    //해당 방식은 audience / ticketOffice 간에 의존성이 추가가 되었다
    //변경 전에는 존재하지 않았던 새로운 의존성이 추가가 되었고, 의존성의 추가는 높은 결합도를 의미하고, 높은 결합도는 변경하기 어려운 설계를 의미한다.
    //결국 트래이드 오프 시점이 온것이고 이 예제를 통해 2가지 사실을 알수있다.
    /**
     * 1. 어떤 기능을 설계하는 방법은 한가지 이상일 수 있다.
     * 2. 동일한 기능을 한가지 이상의 방법으로 설계할 수 있기 때문에 설계는 결국 트레이드오프의 산물이다 -> 어떤 설계도 모든 사람을 만족하는 설계를 만들수 없다
     */
    //훌룡한 객체지향 설계란 소프트웨어를 구성하는 모든 객체들이 자율적으로 행동하는 설계를 의미한다.
  }
}
