package com.gmarket.objectproject;

public class TicketSeller {
  private TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public void sellTo(Audience audience){
    /**
     * TicketSeller에 getTicketOffice() 메서드가 제거가 되었다.
     * ticketOffice에 접근할 수 있는 퍼블릭 메서드가 제거 되어 더이상 외부에서 TicketOffice를 접근할 수 없으며, 티켓을 꺼내거나 판매요금을 적립하는 일을 스스로 할 수 밖에 없다.
     * 이처럼 객체 내부의 세부적인 사항을 감추는 것을 캡슐화라고 한다.
     * 캡슐화를 통해 객체 내부로의 접근을 제한하면 객체와 객체사이의 결합도를 낮출 수 있기 때문에 설계를 좀 더 쉽게 변경할 수 있게 된다.
     *
     * 밀접하게 연관된 작업만을 수행하고 연관성 없는 작업은 다른 객체에게 위임하는 객체를 가르켜 응집도가 높다고 말한다.
     * 자신의 데이터를 스스로 처리하는 자율적인 객체를 만들면 결합도를 낮출 수 있을뿐더러 응집도를 높일 수 있다.
     *
     * 외부의 간섭을 최대한 배제하고 메시지를 통해서만 협력하는 자율적인 객체들의 공동체를 만드는 것이 훌룡한 객체지향 설계를 얻을 수 있는 지름길이다
     */

    /**
     * 절차적 프로그램은 우리의 예상과 너무 쉽게 벗어나기 때문에 코드를 읽는 사람과 원할하게 의사소통하지 못한다.
     * 더 큰 문제는 절차적 프로그래밍의 세상에서는 데이터의 변경으로 인한 영향을 지역적으로 고립시키기 어렵다
     *  Audience와 TicketSeller의 내부 구현을 변경하려면 Theater의 enter 메서드를 함께 변경해야하며, 변경은 버그를 부르고 버그에 대한 두려움은 코드를 변경하기 어렵게 만든다
     * 객체지향 프로그래밍이란 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식
     */

    //TicketSeller가 buy 인터페이스에만 의존하도록 변경
    //ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket())); //TicketSeller는 TicketOffice에 있는 Ticket을 마음대로 꺼내 자기 멋대로 audience에 팔고 Audience에게 받은 돈을 마음대로 저장한다.
    ticketOffice.sellTicketTo(audience);
  }
}
