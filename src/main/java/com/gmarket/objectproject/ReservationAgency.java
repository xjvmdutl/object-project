package com.gmarket.objectproject;

public class ReservationAgency {

  public Reservation reservation(Screening screening, Customer customer, int audienceCount) {
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
  }
}
