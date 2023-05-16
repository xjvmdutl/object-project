package com.gmarket.objectproject;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
  private int addCount = 0;
  /*
  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }
   */

  public int getAddCount() {
    return addCount;
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }
  @Override
  public boolean addAll(Collection<? extends E> c) {
    /**
     * addAll 메서드를 오버라이딩하고 추가되는 각 요소에 대해 한번씩 add 메시지를 호출하는 것으로 위 문제를 해결할 수 있다.
     * 단 이방법도 오버라이딩된 addAll 메서드의 구현이 HashSet의 것과 동일하다는 문제가있다 -> 미래에 발생할지 모르는 위험을 방지하기 위해 코드를 중복시켰다.
     * 또한 부모 클래스의 코드를 그대로 가지고 오는 방법이 항상 가능한 것도 아니기 때문에 해결되었다고 할 수 없다.
     */


    Boolean modified = false;
    for (E e : c) {
      if(add(e))
        modified = true;
    }
    return modified;
  }
}
