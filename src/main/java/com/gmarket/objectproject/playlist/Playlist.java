package com.gmarket.objectproject.playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
  //추가된 요구사항: 가수별 노래의 제목도 관리하자
  private List<Song> tracks = new ArrayList<>();
  private Map<String, String> singers = new HashMap<>();


  public void append(Song song){
    getTracks().add(song);
    singers.put(song.getSinger(), song.getTitle());
  }

  public List<Song> getTracks() {
    return tracks;
  }

  public Map<String, String> getSingers() {
    return singers;
  }
}
