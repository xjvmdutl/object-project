package com.gmarket.objectproject;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * 더이상 불필요한 Hashtable 오퍼레이션들이 Properties 클래스의 퍼블릭 인터페이스를 오염시키지 않는다.
 * 클라이언트는 오직 Properties에서 정의한 오퍼레이션만 사용할 수 있다.
 * Properties의 클라이언트는 모든 타입의 키와 값을 저장할 수 있는 HashTable의 오퍼레이션을 사용할 수 없기 때문에 String 타입의 키와 값만 허용하는 Properties의 규칙을 어길 위험성은 사라진다.
 */
public class Properties {
  private Hashtable<String, String> properties = new Hashtable<>();

  public Properties(Hashtable<String, String> properties) {
    this.properties = properties;
  }

  public Hashtable<String, String> getProperties() {
    return properties;
  }
}
