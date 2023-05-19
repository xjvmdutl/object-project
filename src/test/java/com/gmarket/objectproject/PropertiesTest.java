package com.gmarket.objectproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;
import org.junit.jupiter.api.Test;

public class PropertiesTest {



  @Test
  public void propertiesTest(){
    Properties properties = new Properties();
    properties.setProperty("Bjarne Stroustrup", "C++");
    properties.setProperty("James Gosling", "Java");

    properties.put("Dennis Ritchie", 67);

    assertEquals("C", properties.getProperty("Dennis Ritchie")); //null 반환 -> 반환될 값이 String이 아닐경우 null을 반환하도록 했다.
  }

}
