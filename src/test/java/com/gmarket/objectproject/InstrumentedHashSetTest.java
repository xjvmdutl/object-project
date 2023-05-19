package com.gmarket.objectproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class InstrumentedHashSetTest {

  @Test
  public void instrumentedHashSetTest() {
    InstrumentedHashSet<String> languages = new InstrumentedHashSet<>(new HashSet<>());
    languages.addAll(Arrays.asList("Java", "Ruby", "Scala")); 
    assertEquals(languages.getAddCount(), 3);
  }


}
