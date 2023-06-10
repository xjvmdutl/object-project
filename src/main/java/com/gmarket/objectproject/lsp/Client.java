package com.gmarket.objectproject.lsp;

public class Client {

  public void resize(Rectangle rectangle, int width, int height) {
    rectangle.setWidth(width);
    rectangle.setHeight(height);
    assert rectangle.getWidth() == width && rectangle.getHeight() == height;
  }

  public static void main(String[] args) {
    Client client = new Client();
    Rectangle rectangle = new Rectangle(0, 0, 10, 20);
    client.resize(rectangle, 10 ,20);

    /**
     * Square는 Rectangle의 자식 클래스이기 떄문에 Rectangle이 사용되는 모든 곳에서 Rectangle로 업캐스팅 될 수 있다.(이것이 문제다)
     * resize 메서드의 인자로 Rectangle 대신 Square를 전달한다고 가정해보면 Square의 setWidth 메서드와 setHeight 메서드는 항상 정사각형의 너비와 높이를 같게 설정한다.
     * Square의 너비와 높이는 항상 더 나중에 설정된 height의 값으로 설정된다. --> width와 height 값을 다르게 설정할 경우 메서드 실행이 실패하고 말 것이다.
     * resize 메서드의 구현은 Rectangle이 세운 가정에 기반하기 떄문에 직사각형의 너비와 높이를 독립적으로 변경할 수 있다고 가정한다. 하지만 Rectangle 의 자리에 Square를 전달할 경우 이 가정이 무너진다.
     * resize 메서드의 관점에서 Rectangle 대신 Square를 사용할 수 없기 때문에 Square는 Rectangle이 아니다. Square는 Rectangle의 구현을 재사용하고 있을 뿐이다.
     * 두 클래스는 리스코프 치환 원칙을 위반하기 때문에 서브타이핑 관계가 아니라 서브클래싱 관계다.
     */
    Square square = new Square(10, 10, 10);
    client.resize(square, 50, 100); //실패 => width, height가 100으로 설정
  }
}
