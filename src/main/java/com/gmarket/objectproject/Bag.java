package com.gmarket.objectproject;

public class Bag {
  private Long amount;
  private Invitation invitation;
  private Ticket ticket;

  public Bag(long amount){
    this(null, amount);
  }

  public Bag(Invitation invitation, long amount){
    this.invitation = invitation;
    this.amount = amount;
  }

  private boolean hasInvitation(){
    return invitation != null;
  }

  public boolean hasTicket(){
    return ticket != null;
  }

  //내부에서만 사용하기 때문에 private로 변경
  private void setTicket(Ticket ticket){
    this.ticket = ticket;
  }

  private void minusAmount(Long amount){
    this.amount -= amount;
  }

  public void plusAmount(Long amount){
    this.amount += amount;
  }

  public Long hold(Ticket ticket){
    if(hasInvitation()){
      setTicket(ticket);
      return 0L;
    }else{
      setTicket(ticket);
      minusAmount(ticket.getFee());
      return ticket.getFee();
    }
  }
}
