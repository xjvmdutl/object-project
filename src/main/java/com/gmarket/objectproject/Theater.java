package com.gmarket.objectproject;

public class Theater {

  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    //설계를 변경하기 어려운 이유는 Theater가 Audience와 TicketSeller 뿐 아니라 Audience 소유의 Bag과 TicketSeller가 근무하는 TicketOffice까지 마음대로 접근할 수 있기 때문.
    /**
     * 1. TicketOffice에 접근하는 모든 코드를 TicketSeller 내부로 숨기자
     *    Theater는 오직 TicketSeller의 인터페이스에만 의존하며, TicketSeller가 내부에 TicketOffice 인스턴스를 포함하고 있다는 사실은 구현의 영역에 속한다.
     *    객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하기 위해 따라야하는 가장 기본적인 설계원칙이다.
     * 2. Audience 캡슐화
     * 3. Bag 리펙토링
     */
    ticketSeller.sellTo(audience);
  }
}
