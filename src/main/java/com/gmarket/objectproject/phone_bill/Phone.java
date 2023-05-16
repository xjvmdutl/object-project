package com.gmarket.objectproject.phone_bill;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
  private List<Call> calls = new ArrayList<>();
  /**
   * 자식 클래스는 자시느이 인스턴스를 생성할 때 부모 클래스에 정의된 인스턴스 변수를 초기화해야 하기 때문에 자연스럽게 부모 클래스에 추가된 인스턴스 변수는 자식 클래스의 초기화 로직에 영향을 미치게 된다.
   * 결과적으로 책임을 아무리 잘 분리하더라도 인스턴스 변수의 추가는 종종 상속 계층 전반에 걸친 변경을 유발한다.
   * 객체 생성 로직의 변경에 유연하게 대응할 수 있는 다양한 방법이 존재하므로 해당 변경을 막기보다는 핵심 로직의 중복을 막아라
   * => 핵심 로직은 한곳에 모아 놓고 캡술화 해야하낟. 그리고 공통적인 핵심 로직은 최대한 추상화 해야한다.
   */
  private double taxRate; //클래스 사이의 상속이 자식클래스가 부모 클래스가 구현한 행동뿐 아니라 인스턴스 변수에 대해서도 결합하게 된다.



  public Phone(double taxRate) {
    this.taxRate = taxRate;
  }

  public Money calculateFee() { //메서드를 먼저 옮기는 것이 편하다 -> 메서드를 옮기면 그 메서드가 필요한 메서드, 인스턴스 변수가 무엇인지 컴파일 에러로 자동으로 알 수 있기 때문이다.
    Money result = Money.ZERO;
    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result.plus(result.times(taxRate));
  }

    abstract protected Money calculateCallFee(Call call);//메서드의 구현은 그대로 두고 공통 부분인 시그니처만 부모 클래스로 이동해야한다.
}
