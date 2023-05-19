package com.gmarket.objectproject.playlist;

public class PersonalPlaylist {
  private Playlist playlist = new Playlist();
  public void append(Song song){
    playlist.append(song);
  }

  public void remove(Song song){
    playlist.getTracks().remove(song);
    playlist.getSingers().remove(song.getSinger()); //해당 이슈는 합성으로 변경하여도 해결되지는 않는다.
    //다만 그래도 합성이 좋은 이유는 향후 playlist 내부 구현을 변경하더라도 파급효과를 최대한 PersonalPlaylist 내부로 캡슐화 할 수 있기 떄문이다.
    //몽키 패치: 현재 실행중인 환경에만 영향을 미치도록 지역적으로 코드를 수정하거나 확장하는 것을 가리킨다 -> 루비 = 열린 클래스, c# = 확장 메서드, 자바 = 지원하지 않아 바이트 코드를 직접 넣거나 AOP 사용
  }
}
