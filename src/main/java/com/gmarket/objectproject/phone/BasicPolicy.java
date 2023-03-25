package com.gmarket.objectproject.phone;

import java.util.List;

public abstract class BasicPolicy implements RatePolicy{

  @Override
  public Money calculateFee(List<Call> calls) {
    //사전 조건: calculateFee 오퍼레이션은 파라미터로 전달된 call 목록에 대한 요금의 총합을 계산하므로 call가 null이 아니여야 한다.
    assert calls != null;
    /**
     * 사전 조건을 추가하는 건 클라이언트의 책임이다.
     * 서브타입이 슈퍼타입에 정의된 사전조건을 강화하면 기존에 체결된 계약을 위반하게 된다.
     * 계약서에 명시된 의무보다 더 많은 의무를 짊어져야 한다는 사실을 순순히 납득하는 클라이언트는 없을 겻이다.
     * 결국 사전조건을 강화한 서브타입은 클라이언트의 입장에서 수용이 불가능하기 때문에 슈퍼타입을 대체할 수 없게 되며, 사전조건 강화는 리스코프 치환 원칙 위반이다.
     * 사전 조건 완화시키는 경우 협력에 영향을 끼치지 않게 되므로 리스코프 치환원칙을 위반하지 않는다.
     */
    /*
    // 사전 조건 강화
    assert !calls.isEmpty();
    // 사전 조건 약화
    if(calls == null){
      return Money.ZERO;
    }
     */
    /*
    if(calls == null || calls.isEmpty()){
      throw new EmptyCallException();
    }
     */
    Money result = Money.ZERO;
    for (Call call : calls) {
      result.plus(calculateCallFee(call));
    }

    //사후 조건: 청구서의 요금은 최소한 0원 보다는 크거나 같아야 함으로 사후 조건은 다음과 같다.
    assert result.isGreaterThanOrEqual(Money.ZERO);
    return result;
  }

  protected abstract Money calculateCallFee(Call call);
}
