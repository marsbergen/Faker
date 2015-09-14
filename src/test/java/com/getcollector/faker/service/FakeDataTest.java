package com.getcollector.faker.service;

import com.getcollector.faker.factory.Person;
import junit.framework.TestCase;
import java.util.Locale;

public class FakeDataTest extends TestCase {

  public void testGetString() throws Exception {
    FakeData fakeData = new FakeData(Locale.ENGLISH);

    Person person = new Person(fakeData);
    person.setGender("female");
    String femaleFirstName = person.getFirstName();

    System.out.println(femaleFirstName);
  }
}
