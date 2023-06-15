package com.gmarket.objectproject.defaultinterface;

import com.gmarket.objectproject.reservation.DiscountCondition;
import com.gmarket.objectproject.reservation.Money;
import com.gmarket.objectproject.reservation.Screening;
import java.util.List;

public interface DiscountPolicy {
  default Money calculateDiscountAmount(Screening screening){
    for(DiscountCondition each: getConditions()){
      if(each.isSatisfiedBy(screening)){
        return getDiscountAmount(screening);
      }
    }
    return screening.getMovieFee();
  }
  List<DiscountCondition> getConditions();
  Money getDiscountAmount(Screening screening);
}
