package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectProjectApplication {

  /**
   * 영화 예매 프로그램
   * 영화 / 상영 : 영화는 영화에 대한 정보(제목, 상영시간, 가격정보)를 가진다, 상영은 실제로 관객들이 영화를 관람하는 사건(상영일자, 시간, 순번)
   * 할인액 결정 방법
   * 1. 할인 조건 : 순서조건 = 상영 순번을 이용해 할인 여부 결정 / 기간 조건(요일, 시작시간, 종료시간) = 상영 시작 시간을 이용해 할인 여부 결정
   * 2. 할인 정책 : 금액 할인 정책 = 예매 요금에서 일정 금액을 할인해 주는 방식 / 비율 할인 정책 = 정가에서 일정 비율의 요금을 할인해 주는 방식
   * 요구사항
   * - 영화별로 할인 정책은 1가지 이지만 할인 조건은 여러개일 수 있다.
   * - 할인 조건 중 하나라도 만족하는 조건이 존재할 경우 할인 정책이 적용이된다.
   * - 할인 정책은 1인을 기준으로 책정되며, 사용자가 예매를 완료하면 시스템은 예매 정보(제목, 상영정보, 인원, 정가, 결제금액)를 생성한다
   */
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
