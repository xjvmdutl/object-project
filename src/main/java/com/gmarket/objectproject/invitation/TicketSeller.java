package com.gmarket.objectproject.invitation;

public class TicketSeller {
  private TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  //public void setTicket(Audience audience){ //의도가 명확한가?? //명확하지 않다.
  public void sellTo(Audience audience){
    /*
    if (audience.getBag().hasInvitation()) {
      Ticket ticket = ticketOffice.getTicket();
      audience.getBag().setTicket(ticket);
    } else {
      Ticket ticket = ticketOffice.getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      ticketOffice.plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);
    }
     */
    //ticketOffice.plusAmount(audience.setTicket(ticketOffice.getTicket())); //ticketSeller가 Audience에게 전송하고자 하는 메시지는 티켓을 사도록 만드는 것이 목적이다 (buy가 적합)
    ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
  }

}
