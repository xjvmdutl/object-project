package com.gmarket.objectproject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/*

public class InstrumentedHashSet<E> {
private int addCount = 0;
private Set<E> set;

public InstrumentedHashSet(Set<E> set) {
  this.set = set;
}

public boolean add(E e) {
  addCount++;
  return set.add(e);
}

public boolean addAll(Collection<? extends E> c) {
  addCount += c.size();
  return set.addAll(c);
}

public int getAddCount(){
  return addCount;
}
}
*/

/**
 * HashSet이 제공하는 퍼블릭 인터페이스를 모두 그대로 제공해야하한다 -> 자바의 인터페이스를 사용하면 해결 가능하다.
 * InstrumentedHashSet이 set 인터페이스를 실체화하면서 내부에 HashSet의 인스턴스를 합성하면 HashSet에 대한 구현 결합도는 제거하면서도 퍼블릭 인터페이스는 그대로 유지할 수 있다.
 * Set의 오퍼레이션을 오버라이딩한 인스턴스 메서드에서 내부의 HashSet 인스턴스에게 동일한 메서드 호출을 그대로 전달하는것을 포워딩이라고 부른다.
 * 동일한 메서드를 호출하기 위해 추가된 메서드를 포워딩 메서드라고 부른다.
 * 포워딩은 기존 클래스의 인터페이스를 그대로 제공하면서 구현에 대한 결합 없이 일부 작동 방식을 변경하고 싶은 경우에 사용할 수 있는 유용한 기법이다
 */
public class InstrumentedHashSet<E> implements Set<E> {

  private int addCount = 0;
  private Set<E> set;

  public InstrumentedHashSet(Set<E> set) {
    this.set = set;
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return set.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return set.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }

  @Override
  public boolean remove(Object o) {
    return set.remove(o);
  }

  @Override
  public void clear() {
    set.clear();
  }

  @Override
  public boolean equals(Object o) {
    return set.equals(o);
  }

  @Override
  public int hashCode() {
    return set.hashCode();
  }

  @Override
  public Spliterator<E> spliterator() {
    return set.spliterator();
  }

  @Override
  public int size() {
    return set.size();
  }

  @Override
  public boolean isEmpty() {
    return set.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return set.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return set.iterator();
  }

  @Override
  public Object[] toArray() {
    return set.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return set.toArray(a);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return set.containsAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return set.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return set.removeAll(c);
  }
}
