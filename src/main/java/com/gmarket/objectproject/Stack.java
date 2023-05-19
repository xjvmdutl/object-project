package com.gmarket.objectproject;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * 클라이언트는 더이상 임의의 위치에 요소를 추가하거나 삭제할 수 없다. -> 마지막 위치에서만 요소를 추가, 삭제 할 수 있다는 Stack 규칙을 어길수 없게 된다.
 * 합성 관계로 변경함으로써 클라이언트가 stack을 잘못 사용할 수도 있다는 가능성을 깔끔하게 제거한 것이다.
 */
public class Stack<E> {
  private Vector<E> elements = new Vector<E>();

  public E push(E item){
    elements.addElement(item);
    return item;
  }

  public E pop(){
    if(elements.isEmpty()){
      throw new EmptyStackException();
    }
    return elements.remove(elements.size() - 1);
  }
}
