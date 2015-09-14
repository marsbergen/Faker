/*
 * Copyright (c) 2015. Collector. You are allowed to re-use this code for free, but please share our product in some
 * way on social media or just share some Collector love with the people that are near to you.
 */

package com.getcollector.faker;

import com.getcollector.faker.service.FakeData;
import com.getcollector.faker.factory.Person;

import java.util.Locale;

/**
 * This library will let you apply fake generated date to fill/mock your data source.
 */
public class Faker {

  private final Locale locale;
  private final FakeData fakeData;
  private final Person person;

  public Faker() {
    this(Locale.ENGLISH, new FakeData(Locale.ENGLISH));
  }

  public Faker(Locale locale) {
    this(locale, new FakeData(locale));
  }

  public Faker(Locale locale, FakeData fakeData) {
    this.locale = locale;
    this.fakeData = fakeData;

    this.person = new Person(this.fakeData);
  }

  /**
   * Get a Person object
   *
   * @return Person
   */
  public Person person() {
    return this.person;
  }
}
