/*
 * Copyright (c) 2015. Collector. You are allowed to re-use this code for free, but please share our product in some way
 * on social media or just share some Collector love with the people that are near to you.
 */

package com.getcollector.faker.types;

import com.getcollector.faker.service.FakeData;

import java.util.Random;

public class Person {

  private String[] genders = {"male", "female"};

  private FakeData fakeData;
  private String gender;

  public Person(FakeData fakeData) {
    this.fakeData = fakeData;
  }

  public String getGender() {
    if (this.gender.isEmpty()) {
      return this.genders[new Random().nextInt(this.genders.length)];
    }

    return this.gender;
  }

  public Person setGender(String gender) {
    this.gender = gender;

    return this;
  }

  public String getFullName() {
    String gender = this.getGender();
    String first_name = this.fakeData.getString("person." + gender + ".first_name");
    String last_name = this.fakeData.getString("person." + gender + ".last_name");
    return first_name + " " + last_name;
  }

  public String getFirstName() {
    String gender = this.getGender();
    return this.fakeData.getString("person." + gender + ".first_name");
  }
}
