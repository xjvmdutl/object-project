package com.gmarket.objectproject.phone_bill;

import java.util.List;

public interface FeeCondition {
  List<DateTimeInterval> findTimeIntervals(Call call);
}
