package com.gmarket.objectproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class StackTest {
  @Test
  public void stackTest(){
    Stack<String> stack = new Stack<>();
    stack.push("1st");
    stack.push("2nd");
    stack.push("3rd");

    stack.add(0, "4th"); //add 메서드는 Stack의 부모인 vector의 메서드이다.

    assertEquals("4th", stack.pop()); //에러
  }


}
