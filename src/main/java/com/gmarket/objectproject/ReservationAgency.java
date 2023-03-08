package com.gmarket.objectproject;

public class ReservationAgency {

  public Reservation reservation(Screening screening, Customer customer, int audienceCount) {
    /**
     * reserve 메서드는 길이가 너무 길고 이해하기 어렵다 -> 긴 메서드는 다양한 측면에서 코드 유지보수에 부정적인 영향을 미친다.
     * - 어떤 일을 수행하는지 한눈에 파악하기 어렵기 때문에 코드를 전체적으로 이해하는데 너무 많은 시간이 걸린다.
     * - 하나의 메서드 안에서 너무 많은 작업을 처리하기 때문에 변경이 필요할 때, 수정해야 할 부분을 찾기 어렵다.
     * - 머서드 내부의 일부 로직만 수정하더라도 메서드의 나머지 부분에서 버그가 발생할 확률이 높다.
     * - 로직의 일부만 재사용하는 것이 불가능하다
     * - 코드를 재사용하는 유일한 방법은 원하는 코드를 복사해서 붙여넣는 것뿐이므로 코드 중복을 초래하기 쉽다.
     * 긴 메서드는 응집도가 낮기 때문에 이해하기도 어렵고 재사용하기도 어려우며 변경하기도 여렵다 -> 몬스터 메서드
     * 응집도가 낮은 메서드는 로직의 흐름을 이해하기 위해 주석이 필요한 부분이 대부분이며, 메서드가 명력문들의 그룹으로 구성되고 각 그룹에 주석을 달아야 할 필요가 있다면 그 메서드의 응집도는 낮은것이다.
     * -> 주석을 추가하는 대신 메서드를 작게 분해해서 각 메서드의 응집도를 높여라
     * 응집도 높은 메서드는 변경되는 이유가 단 하나여야한다. 클래스가 작고, 목적이 명확한 메서드들로 구성돼 있다면, 변경을 처리하기 위해 어떤 메서드를 수정행야 하는지를 쉽게 판단할 수 있다.
     * 또한 메서드의 크기가 작고 목적이 분명하기 때문에 재사용하기도 쉬우며, 작은 메서드들로 조합된 메서드는 마치 주석들을 나열한 것처럼 보이기 때문에 코드를 이해하기도 쉽다.
     * 객체로 책임을 분배할 때 가장 먼저 할 일은 메서드를 응집도 있는 수준으로 분해하는 것이다. -> 긴 메서드를 작고, 응집도 높은 메서드로 분리하면 각 메서드를 적절한 클래스로 이동하기가 더 수월해지기 때문이다.
     */
    /*
    Movie movie = screening.getMovie();

    boolean discountable = false;
    for (DiscountCondition condition : movie.getDiscountConditions()) { //할인 가능 여부를 체크하느 부분
      if (condition.getType() == DiscountConditionType.PERIOD) {
        discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
            && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
            && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
      } else {
        discountable = condition.getSequence() == screening.getSequence();
      }
      if (discountable) {
        break;
      }
    }
    Money fee;
    if (discountable) {
      Money discountAmount = Money.ZERO;
      switch (movie.getMovieType()) { //적절한 할인 정책에 따라 예매 요금을 계산하는 구문
        case AMOUNT_DISCOUNT:
          discountAmount = movie.getDiscountAmount();
          break;
        case PERCENT_DISCOUNT:
          discountAmount = movie.getFee().times(movie.getDiscountPercent());
          break;
        case NONE_DISCOUNT:
          discountAmount = Money.ZERO;
          break;
      }
      fee = movie.getFee().minus(discountAmount);
    } else {
      fee = movie.getFee();
    }
    return new Reservation(customer, screening, fee, audienceCount);
     */
    /**
     * 수정 후에는 메서드가 어떤일을 하는지를 한눈에 알아볼 수 있다.
     * 코드를 작은 메서드들로 분해하면 전체적인 흐름을 이해하기도 쉬워진다.
     * 동시에 너무 많은 세부사항을 기억하도록 강요하는 코드는 이해하기도 어렵다 -> 큰 메서드를 작은 메서드들로 나누면 한 번에 기억해야 하는 정보를 줄일 수 있다.
     * 수정 후의 코드는 변경하기도 더 쉽다 -> 각 메서드는 단 하나의 이유에 의해서만 변경되기 떄문이다.
     * 메서드들이 하나의 변경 이유를 가지도록 개선될 때 결과적으로 응집도 높은 클래스가 만들어진다.
     *
     * 메서드들의 응집도 자체는 높아졌으나, ReservationAgency 의 응집도는 아직 낮다 -> 응집도를 높이기 위해서는 변경의 이유가 다른 메서드들을 적절한 위치로 분배해야한다.
     */
    boolean discountable = checkDiscountable(screening);
    Money fee = calculateFee(screening, discountable, audienceCount);
    return createReservation(screening, customer, audienceCount, fee);
  }

  /*
    private boolean checkDiscountable(Screening screening) {
      return screening.getMovie().getDiscountConditions().stream()
          .anyMatch(condition -> isDiscountable(condition, screening));
    }

    private boolean isDiscountable(DiscountCondition condition, Screening screening) {
      if (condition.getType() == DiscountConditionType.PERIOD) {
        return isSatisfiedByPeriod(condition, screening);
      }
      return isSatisfiedBySequence(condition, screening);
    }

    private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
      return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
          && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
          && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
      return condition.getSequence() == screening.getSequence();
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
      if (discountable) {
        return screening.getMovie().getFee()
            .minus(calculateDiscountFee(screening.getMovie()))
            .times(audienceCount);
      }
      return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountFee(Movie movie) {
      switch (movie.getMovieType()) {
        case AMOUNT_DISCOUNT:
          return calculateAmountDiscountedFee(movie);
        case PERCENT_DISCOUNT:
          return calculatePercentDiscountedFee(movie);
        case NONE_DISCOUNT:
          return calculateNoneDiscountedFee(movie);
      }
      throw new IllegalArgumentException();
    }


    private Money calculateAmountDiscountedFee(Movie movie) {
      return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
      return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
      return Money.ZERO;
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount,
        Money fee) {
      return new Reservation(customer, screening, fee, audienceCount);
    }

   */


  private boolean checkDiscountable(Screening screening) {
    return screening.getMovie().getDiscountConditions().stream()
        .anyMatch(condition -> condition.isDiscountable(condition, screening));
  }

  private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
    if (discountable) {
      return screening.getMovie().getFee()
          .minus(calculateDiscountFee(screening.getMovie()))
          .times(audienceCount);
    }
    return screening.getMovie().getFee().times(audienceCount);
  }

  private Money calculateDiscountFee(Movie movie) {
    switch (movie.getMovieType()) {
      case AMOUNT_DISCOUNT:
        return calculateAmountDiscountedFee(movie);
      case PERCENT_DISCOUNT:
        return calculatePercentDiscountedFee(movie);
      case NONE_DISCOUNT:
        return calculateNoneDiscountedFee(movie);
    }
    throw new IllegalArgumentException();
  }


  private Money calculateAmountDiscountedFee(Movie movie) {
    return movie.getDiscountAmount();
  }

  private Money calculatePercentDiscountedFee(Movie movie) {
    return movie.getFee().times(movie.getDiscountPercent());
  }

  private Money calculateNoneDiscountedFee(Movie movie) {
    return Money.ZERO;
  }

  private Reservation createReservation(Screening screening, Customer customer, int audienceCount,
      Money fee) {
    return new Reservation(customer, screening, fee, audienceCount);
  }
}
