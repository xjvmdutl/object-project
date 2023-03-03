package com.gmarket.objectproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 캡슐화 위반
 * DiscountCondition의 isDiscountable(DayOfWeek dayOfWeek, LocalTime time) 메서드 같은 경우 객체 내부에 DayOfWeek 타입의 요일과 LocalTime 타입의 시간 정보가 인스턴스 변수로 포함돼 있다는 사실을 인터페이스를 통해 외부로 노출하고 있다.
 * DiscountCondition의 isDiscountable(int sequence) 메서드 역시 객체가 int 타입의 순번 정보를 포함하고 있음을 외부에 노출한다.
 * DiscountCondition의 getType() 메서드를 통해 내부에 DiscountConditionType을 포함하고 있다는 정보 역시 노출시키고 있다.
 * 만약 DiscountCondition의 속성을 변경하게 된다면 해당 메서드를 사용하는 모든 클라이언트와 해당 메서드의 파라미터 모두 수정해야한다 -> 내부 구현의 변경이 외부로 퍼져나가는 파급효과는 캡슐화가 부족하다는 명백한 증거입니다.
 * Movie 또한 캡슐화가 부족하긴 마찬가지인데, calculateAmountDiscountedFee, calculatePercentDiscountedFee, calculateNoneDiscountedFee 메서드는 파라미터, 반환 값으로는 속성을 어느 정보도 노출하고 있진 않지만, 할인 정책을 종류를 노출하고 있다.
 * 세개의 메서드는 할인 정책에는 금액할인정책, 비율할인정책, 미적용 3가지 정책이 존재한다는 사실이 만천하에 공개된다. ->새로운 할인 정책이 추가, 삭제되면 이 메서드에 의존하는 클라이언트 모두 영향을 받는다.
 *
 * 높은 결합도
 * Movie, DiscountCondition의 내부 구현이 외부로 노출됐기 떄문에 둘 사이의 결합도는 높을 수 밖에 없다 -> 결합도가 높을 경우 한 객체의 구현을 변경할 때 다른 객체에게 변경의 영향이 전파될 확률이 높아진다.
 * DiscountCondition이 Movie에 미치는 영향을 살펴보면, 아래 3가지 이다.
 * - DiscountCondition의 기간할인조건의 명칭이 PERIOD에서 다른 값으로 변경된다면 Movie는 수정되어야한다.
 * - DiscountCondition의 종류가 추가,삭제된다면 Movie 안의 if ~ else 구문을 수정해야한다.
 * - DiscountCondition의 만족 여부를 판단하는데 필요한 정보가 변경된다면 Movie의 isDiscountable 메서드로 전달된 파라미터를 변경해야한다. -> Movie의 isDiscountable 메서드 시그니처도 변경되므로 이 메서드를 의존하는 Screening에 대한 변경을 초래한다.
 * DiscountCondition의 구현의 변경하는 경우에도 DiscountCondition에 의존하는 Movie를 변경해야한다는 것은 두 객체 사이의 결합도가 높아진다는 것을 의미한다.
 * -> 이러한 모든 문제는 캡슐화 원칙을 지키지 못했기 때문이다.
 *
 * 낮은 응집도
 * 할인 조건의 종류를 변경하기 위해서는 DiscountCondition, Movie, Screening 모두 수정해야한다. -> 하나의 변경을 수용하기 위해 코드 여러곳을 동시에 변경한다는 것은 설계의 응집도가 낮다는 것을 의미
 * 응집도가 낮은 이유는 캡슐화를 위반했기 때문이다.
 * -> DiscountCondition과 Movie의 내부 구현이 인터페이스에 그대로 노출되고 있고 Screening은 노출된 구현에 직접적으로 의존하고 있다. DiscountCondition,Movie에 위치해야할 로직이 Screening에 새어나왔기 때문이다.
 *
 * 데이터 중심 설계의 문제점
 * - 데이터 중심 설계는 객체의 행동보다는 상태에 초점을 맞춘다.
 *    데이터 중심 설계는 "이 객체가 포함해야할 데이터가 무엇인가?"라는 질문을 처음 시작하고, 이는 구현에 해당한다. -> 너무 이른 시기에 내부 구현에 초점이 맞춰진다.
 *    1) 데이터 중심 설계의 개발자는 일반적으로 절차적 프로그래밍 방식을 따르게 되고, 이로 인해 과도한 접근자, 수정자를 추가하게 되고 이 데이터 객체를 사용하는 절차를 분리된 별도의 객체 안에서 구현하게 된다.
 *    -> 접근자와 수정자는 public 속성과 큰 차이가 없으므로 객체의 캡슐화는 완전히 무너지게 된다.
 *    2) 데이터를 처리하는 작업과 데이터를 같은 객체 안에 두더라도 데이터에 초점이 맞춰있다면 만족스러운 캡슐화를 하지 못하는데, 데이터를 먼저 결정하고 처리하는데 필요한 오퍼레이션을 나중에 결정하는 방식은 데이터에 관한 지식이 객체의 인터페이스에 드러나게 된다.
 *    -> 객체의 인터페이스는 구현을 캡슐화하는데 실패하고 코드는 변경에 취약해진다.
 * - 데이터 중심 설계에서는 협력이라는 문맥을 고려하지 않고 객체를 고립시킨 채 오퍼레이션을 결정한다.
 *    객체지향 어플리케이션을 구현한다는 것은 협력하는 객체들의 공동체를 구축한다는 의미로 협력이라는 문맥안에서 필요한 책임을 결정하고 이를 수행할 적절한 객체를 결정하는것이 중요하다.
 *    올바른 객체지향 설계의 무게중심은 항상 객체의 내부가 아니라 외부에 맞춰져 있어야 한다(어떤 상태를 가지고 관리하는가는 부가적인 문제로 다른 객체와 협력하는 방법이 주 문제이다)
 *    데이터 중심 설계에서 초점은 객체의 외부가 아닌 내부로 향한다 -> 객체의 구현이 이미 결정된 상태에서 다른 객체와의 협력을 고민하기 떄문에 이미 구현된 객체의 인터페이스를 억지로 끼워맞출수 밖에 없다.
 *    객체의 인터페이스에 구현이 노출되어 있었기 때문에 협력이 구현 세부사항에 종속돼 있고, 그에 따라 객체의 내부 구현이 변경됐을때, 협력하는 객체 모두가 영향을 받을 수밖에 없었던 것이다.
 */
@SpringBootApplication
public class ObjectProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(ObjectProjectApplication.class, args);
  }

}
