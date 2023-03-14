package com.gmarket.objectproject.invitation;

public class Theater {

  /**
   * 디미터 법칙을 위반하는 티켓 판매 도메인
   */
  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    /*
    if (audience.getBag().hasInvitation()) {  //Theater가 audience와 ticketSeller 내부의 포함된 객체에도 직접 접근
      //해당 객체들이 직접 작업을 수행할 수 있도록 시켜야한다
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().setTicket(ticket);
    } else { //없는경우
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);
    }
     */
    //ticketSeller.setTicket(audience); //Theater가 TicketSeller에게 setTicket 메시지를 전송해서 얻고 싶었던 결과는 바로 Audience에게 티켓을 판매하는 것이다.
    ticketSeller.sellTo(audience); //따라서 sellTo(판매하라) 라는 메시지가 더 좋다
  }
}
