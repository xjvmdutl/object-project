package com.gmarket.objectproject.invitation;

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
  public Long hold(Ticket ticket){
    /**
     * 사후조건(하나 이상의 리턴을 가질 경우)
     * Contract.Result<T>는 메서드 실행이 끝난 후에 실제로 반환되는 값을 전달하기 때문에 몇 번의 return문이 나오더라도 한번만 기술하면 된다.
     */
    //Contract.Ensures(Contract.Result<Long>() >= 0)

    if (hasInvitation()) {
      this.ticket = ticket;
      return 0L;
    } else {
      this.ticket = ticket;
      minusAmount(ticket.getFee());
      return ticket.getFee();
    }
  }
  private boolean hasInvitation() {
    return invitation != null;
  }

  private void minusAmount(Long amount) {
    this.amount -= amount;
  }
}
