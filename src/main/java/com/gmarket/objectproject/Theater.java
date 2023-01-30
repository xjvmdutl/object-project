package com.gmarket.objectproject;

public class Theater {

  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    //해당 메서드를 말로 풀어써보자
    /**
     * 소극장은 관람객의 가방을 열어 그 안에 초대장이 들어 있는지를 살펴본다. 가방 안에 초대장이 들어 있으면 판매원은 매표소에 보관돼 있는
     * 티켓을 관람객의 가방 안으로 옮긴다. 가방 안에 초대장이 들어 있지 않다면, 관람객의 가방에서 티켓 금액만큼의 현금을 꺼내 매표소에 적립한
     * 매표소에 보관돼 있는 티켓을 관람객의 가방 안으로 옮긴다
     */
    //여러 문제점 분석
    /**
     * 1. 현실세계와는 너무 괴리감이 존재 : Theater가 관람객을 가방을 뒤지고 있으며, 메표소에 보관중인 티켓과 현금에 마음대로 접근한다
     * 2. enter 코드를 이해하기 위해 너무 많은 정보를 알고 있어야 한다 -> Audience가 bag을 가지고 있으며, bag 안에 현금이 있고... 등 너무 많은 정보를 가진다.
     * 3. Audience와 TicketSeller를 변경할 경우 Theater도 함께 변경이 되어야한다.
     */
    //의존성은 변경과 관련되어 있으며, 이는 즉, 어떤 객체가 변경될 떄 의존하고 있는 다른 객체도 함께 변경될 수 있는 사실을 의미한다.
    //객체 사이에 의존성이 과한 경우를 결합도가 높다고 하며, 결합도가 높을 경우 변경에 취약하므로 결합도를 낮춰 변경이 용이한 설계를 만들어야 한다.
    if (audience.getBag().hasInvitation()) {
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().setTicket(ticket);
    } else { //없는경우
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);
    }
  }
}
