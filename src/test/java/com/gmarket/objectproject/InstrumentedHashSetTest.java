package com.gmarket.objectproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class InstrumentedHashSetTest {

  @Test
  public void instrumentedHashSetTest() {
    InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
    languages.addAll(Arrays.asList("Java", "Ruby", "Scala")); 
    //addCount가 3이 될것으로 예상되지만 6이 된다. -> Hashset의 addAll 메서드 안에서 add 메서드를 호출하기 때문에
    assertEquals(languages.getAddCount(), 3);
  }


}
