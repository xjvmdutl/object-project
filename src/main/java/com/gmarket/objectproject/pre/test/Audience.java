package com.gmarket.objectproject.pre.test;

public class Audience {
  private Bag bag;

  public Audience(Bag bag){
    this.bag = bag;
  }

  //public Long setTicket(Ticket ticket){
  public Long buy(Ticket ticket){
    /*
    if (bag.hasInvitation()) {
      bag.setTicket(ticket);
      return 0L;
    } else {
      bag.setTicket(ticket);
      bag.minusAmount(ticket.getFee());
      return ticket.getFee();
    }
     */
    //return bag.setTicket(ticket);
    return bag.hold(ticket);
  }
}