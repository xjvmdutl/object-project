package com.gmarket.objectproject.phone_bill;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
  private List<Call> calls = new ArrayList<>();

  public Money calculateFee(){
    Money result = Money.ZERO;
    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result;
  }

    abstract protected Money calculateCallFee(Call call);
    //부모 클래스에 추상 메서드를 추가하면 모든 자식 클래스들이 추상 메서드를 오버라이딩해야 하는 문제가 발생한다. -> 자식 클래스 많다면 번거롭다
    //모든 추상 메서드의 구현 역시 동일하다 -> 우연성은 유지 하면서도 중복 코드를 제거할 수 있는 방법은 기본 구현을 함께 제공하면 된다.
    //abstract protected Money afterCalculated(Money fee);
    protected Money afterCalculated(Money fee){
      return fee;
    }


}