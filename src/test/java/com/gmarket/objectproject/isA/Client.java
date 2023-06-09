package com.gmarket.objectproject.isA;

public class Client {

  public static void main(String[] args) {
    Client client = new Client();
    //client.flyBird(new Bird());
    //client.flyBird(new Penguin()); //날지 못한다.
    client.flyBird(new FlyingBird());
  }
  //private void flyBird(Bird bird){
    //인자로 전달된 bird는 모두 날 수 있어야 한다.
    /**
     * Penguin은 Bird의 자식 클래스이기 때문에 컴파일러는 업캐스팅을 허용하고, flyBird 메서드의 인자로 Penguin의 인스턴스가 전달되는 것을 막을 수 있는 방법이 없다.
     * 하지만 penguin은 날 수 없고 클라이언트는 모든 bird가 날 수 있기를 기대하기 때문에 flyBird 메서드로 전달되서는 안된다.
     * Penguin은 클라이언트의 기대를 저버리기 때문에 Bird의 서브타입이 아니다. 따라서 이 둘을 상속 관계로 연결한 위 설계는 수정되어야한다.
     * 상속관계를 유지하면서 해결할 수 있는 방법이 3가지 있다
     */
    /**
     * 세번째 방법은 flyBird 메서드를 수정해서 인자로 전달된 bird의 타입이 Penguin이 아닐 경우에만 fly 메시지를 전송하도록 하는 것이다.
     * 만약 Penguin 이외에 날 수 없는 또다른 새가 상속 계층에 추가된다면 어떻게 할 것인가?
     * flyBird 메서드 안에서 instanceof를 이용해 새로운 타입을 체크하는 코드를 추가해야 할 것이다. 이것은 new 연산자와 마찬가지로 구체적인 클래스에 대한 결합도를 높인다.
     * 일반적으로 instanceof처럼 객체의 타입을 확인하는 코드는 새로운 타입을 추가할 때마다 코드 수정을 요구하기 때문에 개방-폐쇄 원칙을 위반한다.
     */
    //인자로 전달된 모든 bird가 Penguin의 인스턴스가 아닐 경우에만 fly() 메시지를 전송한다.
    /*
    if (!(bird instanceof Penguin)){
      bird.fly();
    }
     */
  private void flyBird(FlyingBird bird){
    /**
     * Bird의 클라이언트는 자신과 협력하는 객체들이 fly라는 행동을 수행할 수 없다는 사실을 잘 알고 잇다. 따라서 Penguin이 Bird를 대체하더라도 놀라지 않을 것이다.
     * FlyBird 역시 Bird와 행동적인 측면에서 호환 가능한데 Bird의 클라이언트는 fly 메시지를 전송할 수 없기 때문에 Bird 대신 FlyBird 인스턴스를 전달하더라도 문제가 되지 않기 때문이다.
     * 이제 FlyingBird 타입의 인스턴스만이 fly 메시지를 수신할 수 있다. 날 수 없는 bird의 서브타입인 Penguin의 인스턴스에게 fly 메시지를 전송할 수 있는 방법은 없다.
     * 따라서 잘못된 객체와 협력해서 기대했던 행동이 수행되지 않거나 예외가 던져지는 일은 일어나지 않을 것이다.
     * 이 문제를 해결하는 다른 방법은 클라이언트에 따라 인터페이스를 분리하는 것이다.
     */
    bird.fly();
  }

}
