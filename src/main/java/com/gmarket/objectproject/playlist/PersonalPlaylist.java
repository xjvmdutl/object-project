package com.gmarket.objectproject.playlist;

public class PersonalPlaylist extends Playlist{
  public void remove(Song song){
    getTracks().remove(song);
    getSingers().remove(song.getSinger()); //이걸 하지 않는다면 Singer에는 남아있지만 track에만 제거된다.
    /**
     * 자식 클래스가 부모 클래스의 메서드를 오버라이딩하거나 불필요한 인터페이스를 상속받지 않았음에도 부모 클래스를 수정할 때 자식 클래스를 함께 수정해야 할 수도 있다는 시실을 보여준다.
     * 상속을 사용하면 자식 클래스가 부모 클래스의 구현에 강하게 결합되기 때문에 이 문제를 피하기는 어렵다.
     * 코드 재사용을 위한 상속은 부모 클래스와 자식 클래스를 강하게 결합시키기 때문에 함께 수정해야하는 상황 역시 빈번하게 발생할 수밖에 없는 것이다.
     * - 클래스를 상속하면 결합도로 인해 자식 클래스와 부모 클래스의 구현을 영원히 변경하지 않거나 자식 클래스와 부모 클래스를 동시에 변경하거나 둘 중 하나를 선택할 수 밖에 없다.
     */
  }
}
