package com.getcollector.faker.service;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class FakeDataTest extends TestCase {

  @Test
  public void testGetString() throws Exception {
    FakeData fakeData = new FakeData(Locale.ENGLISH);

    String femaleFirstName = fakeData.getString("person.female.first_name");

    System.out.println(femaleFirstName);
  }
}
