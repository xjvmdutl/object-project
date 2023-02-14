package com.gmarket.objectproject;

import java.time.LocalDateTime;

public class Screening {
  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
    this.movie = movie;
    this.sequence = sequence;
    this.whenScreened = whenScreened;
  }

  /**
   * 상영 시작 시간 반환
   * @return
   */
  public LocalDateTime getStartTime(){
    return whenScreened;
  }

  /**
   * 순번의 일치 여부를 검사
   * @param sequence
   * @return
   */
  public boolean isSequence(int sequence){
    return this.sequence == sequence;
  }


  /**
   * 클래스를 구현하거나 다른 개발자에 의해 개발된 클래스를 사용할 때 가장 중요한 건 클래스의 경계를 구분짓는 것이다.
   * 어떤 부분을 외부에 공개하고, 어떤 부분을 감출지를 결정하는 것이 클래스 설계의 핵심이다.
   * 외부에서 객체의 속성에 직접 접근할 수 없도록 막고 적절한 public 메서드를 통해서만 내부 상태를 변경할 수 있게 해야한다.
   *
   * 클래스의 내부와 외부를 구분하는 이유는 경계의 명확성이 객체의 자율성의 보장하고, 프로그래머에게 구현의 자유를 제공하기 때문이다.
   * 객체는 상태와 행동을 함께 가지는 복합적인 존재로 스스로 판단하고 행동하는 자율적인 존재이다.
   *
   * 객체지향은 객체라는 단위안에 데이터와 기능을 한 덩어리로 묶음으로써 문제 영역의 아이디어를 적절하게 표현할 수 있게 했다(캡슐화)
   * 객체지향은 외부에서 접근을 통제할 수 있는 접근제어 메커니즘도 제공하며, 접근 제어를 위해 public, protected, private와 같은 접근 수정자도 제공한다.
   * 객체 내부에 접근을 통제하는 이유는 객체를 자율적인 존재로 만들기 위해서며, 객체지향 핵심은 객체가 스스로 상태를 관리하고 판단하고 행동하는 객체들의 공동체를 구성하는 것이다.
   * 객체가 자율적인 존재가 되기 위해서는 외부의 간섭을 최소화해야하며, 객체가 어떤 상태인지, 어떤 생각을 하는지, 결정에 직접적으로 개입하려고 해서도 안된다.
   *
   * 캡슐화와 접근제어는 객체를 2부분으로 나눈다.
   * 1) 외부에서 접근 가능한 부분으로 퍼블릭 인터페이스라 부른디.
   * 2) 외부에서 접근 불가능하고 오직 내부에서만 접근 가능한 부분으로 구현이라고 부른다.
   * 일반적으로 객체의 상태는 숨기고 행동만 외부로 공개해야하며, 클래스의 속성은 private로 선언해 감추고 외부에 공개할 일부 메서드만 public으로 선언해야한다.
   * 어떤 메서드들이 서브 클래스나 내부에서만 접근 가능해야 한다면, 가시성을 protected/ private로 지정해야한다.(public=퍼블릭 인터페이스, private/protected = 구현)
   *
   * 프로그래머의 역할은 클래스 작성자(새로운 데이터 타입을 프로그램에 추가) / 클라이언트 프로그래머(클래스 작성자가 추가한 데이터 타입을 사용)로 구분하는 것이 좋다
   * 클라이언트 프로그래머는 필요한 클래스들을 엮어서 애플리케이션을 빠르고 안정적으로 구축하는 것이고, 클래스 작성자는 클라이언트 프로그래머에게 필요한 부분만 공개하고 나머지는 꽁꽁 숨겨야한다.
   * 구현 은닉이란 클라이언트 프로그래머가 숨겨 놓은 부분에 마음대로 접근할 수 없도록 방지 함으로써 클라이언트 프로그래머에 대한 영향을 걱정하지 않고도 내부 구현을 마음대로 변경할 수 있는것이다.
   *
   * 접근 제어 메커니즘은 프로그래밍 언어 차원에서 클래스의 내부와 외부를 명확하게 경계 지을  수 있게 하는 동시에 클래스 작성자가 내부 구현을 은닉할 수 있게 해준다.
   * 또한 클라이언트 프로그래머가 실수로 숨겨진 부분에 접근하는 것을 막아준다(private 속성이나 메서드 접근 시 컴파일 오류 발생)
   *
   * 구현 은닉은 클래스 작성자는 인터페이스를 바꾸지 않는 한 외부에 미치는 영향을 걱정하지 않고 내부 구현을 변경할 수 있게 하고,
   * 클라이언트 프로그래머가 알아야할 지식을 양을 줄여준다(인터페이스만 알면 되기 때문)
   *
   */
  public Money getMovieFee(){
    return movie.getFee();
  }


  public Reservation reserve(Customer customer, int audienceCount){
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }
}
