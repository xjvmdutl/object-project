package com.gmarket.objectproject;

public class ReservationAgency {

  public Reservation reservation(Screening screening, Customer customer, int audienceCount) {

    boolean discountable = checkDiscountable(screening);
    Money fee = calculateFee(screening, discountable, audienceCount);
    return createReservation(screening, customer, audienceCount, fee);
  }

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
