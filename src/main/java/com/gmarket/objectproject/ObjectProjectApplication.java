package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 현대적인 프로그래밍 언어를 특징 짓는 2가지 추상화 메커니즘은 프로시저 추상화, 데이터 추상화이다.
 * 프로시저 추상화는 소프트웨어가 무엇을 해야하는지를 추상화한다.
 * 데이터 추상화는 소프트웨어가 무엇을 알아야 하는지를 추상화한다.
 * 시스템을 분해하는 방법을 결정하려면 먼저 프로시저 추상화를 중심으로 할 것인지, 데이터 추상화를 중심으로 할 것인지를 결정해야한다.
 * 프로시저 추상화를 중심으로 시스템을 분해하기로 결정했다면 기능 분해의 길로 들어서는 것이며, 기능 분해는 알고리즘 분해라고 부르기도 한다.
 * 데이터 추상화를 중심으로 시스템을 분해하기로 결정했다면 데이터 중심으로 타입을 추상화 할지, 데이터를 중심으로 프로시저를 추상화 할지 선택해야한다.
 * 데이터 중심으로 타입을 추상화 하는것을 추상 데이터 타입이라 하고, 데이터를 중심으로 프로시저를 추상화 하는것을 객체지향이라고 부른다.
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }
}
