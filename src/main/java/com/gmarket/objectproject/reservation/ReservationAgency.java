package com.gmarket.objectproject.reservation;

public class ReservationAgency {
  public Reservation reservation(Screening screening, Customer customer, int audienceCount){
    //Contract.Requires(customer != null);
    //Contract.Requires(audienceCount >= 1);
    /**
     * 사전조건
     * 메서드의 사전조건을 정의하기 위해 사용하는 메서드는 Contract의 requires 메서드이다.
     * 시전조건을 만족시킬 책임은 Reserve 메서드를 호출한는 클라이언트에게 있음을 기억하자
     * Contract.Requires 메서드는 클라인언트가 계약에 명시된 조건을 만족시키지 못할 경우 ContractException 예외를 발생시킨다.
     * 계약에 의한 설계를 사용하면 계약만을 위해 준비된 전용 표기법을 사용해 계약을 명확하게 표현할 수 있다.
     * 또한 계약을 일반 로직과 분리해서 서술함으로써 계약을 좀 더 두드러지게 강조할 수 있다
     * 또한 계약이 메서드의 일부로 실행되도록 함으로써 계약을 강제할 수 있다.
    */
    //Contract.Ensures(Contract.Result<Reservation>() != null);
    /**
     * 사후조건
     * Contract.Ensures() 메서드를 통해 사후조건을 정의하면 된다.
     * Contract.Result<T> 메서드가 Reserve 메서드의 실행결과에 접근할 수 있게 해주는 메서드이다
     * -> 제네릭 타입으로 메서드의 반환 타입에 대한 정보를 명시할 것을 요구한다.
     */

    Money fee = screening.calculateFee(audienceCount);
    return new Reservation(customer, screening, fee, audienceCount);
  }
}
