package com.gmarket.objectproject.phone;

import java.util.List;

public abstract class AdditionalRatePolicy implements RatePolicy{
  protected RatePolicy next;

  public AdditionalRatePolicy(RatePolicy next) {
    //this.next = next;
    changeNext(next);
    //불변식
    assert next != null;
  }

  @Override
  public Money calculateFee(List<Call> calls) {
    //불변식
    assert next != null;
    //사전 조건
    assert calls != null;
    Money fee = next.calculateFee(calls);
    Money result = afterCalculated(fee);

    /**
     * 사후조건 약화
     * //assert result.isGreaterThanOrEqual(Money.ZERO);
     * 사후조건을 약화하였더니, 이상한 곳(Bill의 생성자)에서 오류가 발생한다.
     * AdditionalRatePolicy가 사후조건을 완화함으로써 기존에 Phone과 RatePolicy 사이에 체결된 계약을 위반했기 때문에 생기는 문제인데, 엉뚱한 곳에서 오류가 발생한다.
     * 사후조건을 완화한다는 것은 서버가 클라이언트에게 제공하겠다고 보장한 계약을 충족시켜주지 못한다는 것을 의미한다.
     * 서버는 계약을 위반했기 떄문에 이제 계약은 유효하지 않고, 클라이언트 Phone의 입장에서 AdditionalRatePolicy 는 더이상 RatePolicy가 아니다.
     * 결국 사후조건을 완화시키는 서버는 클라이언트의 관점에서 수용할 수 없기 때문에 슈퍼 타입을 대체할 수 없고, 리스코프 치환 원칙 위반이다.
     *
     * 사후조건이 강화
     * //assert result.isGreaterThanOrEqual(Money.wons(100);
     * 반대로 사후조건이 강화되더라도 계약에는 영향이 가지 않으므로 리스코프 치환 원칙을 지킨다.
     *
     * 일찍 실패하기
     * 문제가 발생한 위치에서 프로그램이 실패하도록 코드를 만들어라
     */

    //사후 조건
    assert result.isGreaterThanOrEqual(Money.ZERO);
    //불변식
    assert next != null;
    return result;
  }

  protected void changeNext(RatePolicy next){
    this.next = next;
    //불변식
    assert next != null;
  }

  abstract protected Money afterCalculated(Money fee);
}
