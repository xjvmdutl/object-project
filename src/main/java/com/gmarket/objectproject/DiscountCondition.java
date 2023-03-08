package com.gmarket.objectproject;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  /**
   * 자신이 소유하고 있는 데이터를 자기 스스로 처리하도록 만드는 것이 자율적인 객체를 만드는 지름길이다.
   * isDiscountable 메서드는 외부에서 호출 가능하도록 가시성을 private -> public으로 변경하였다.
   * isDiscountable 메서드가 ReservationAgency에 속할 떄는 구현의 일부였지만 DiscountCondition으로 이동한 후에는 퍼블릭 인터페이스의 일부가 된 것이다.
   * 메서드를 다른 클래스로 이동시킬 때는 인자에 정의된 클래스 중 하나로 이동하는 경우가 일반적이다.
   * 이제 DiscountCondition을 모든 접근자 메서드를 지울 수 있고, 이를 통해 DiscountCondition 내부 구현을 캡슐화 할 수 있다.
   * 책임 주도 설계 방법에 익숙하지 않다면 일단 데이터 중심으로 구현한 후, 이를 리펙터링하더라도 유사한 결과를 얻을 수 있다.
   * 처음부터 책임 주도 설계 방법을 따르는 것보다 동작하는 코드를 작성한 후에 리펙터링하는 것이 더 훌룡한 결과물을 낳을 수도 있다.
   */
  public boolean isDiscountable(DiscountCondition condition, Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
      return isSatisfiedByPeriod(condition, screening);
    }
    return isSatisfiedBySequence(condition, screening);
  }

  private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
    return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek)
        && startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
        && endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
  }

  private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
    return sequence == screening.getSequence();
  }
}
