/*
 * Copyright (c) 2015. Collector. You are allowed to re-use this code for free, but please share our product in some way
 * on social media or just share some Collector love with the people that are near to you.
 */

package com.getcollector.faker.service;

import org.apache.commons.lang.math.RandomUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FakeData {
  private final Locale locale;
  private final Map<String, Object> fakeDataMap;

  public FakeData(Locale locale) {
    this.locale = locale;

    String languageCode = this.locale.getLanguage();
    InputStream stream = this.findStream(languageCode + ".yml");

    if (stream == null) {
      throw new LocaleDoesNotExistException(String.format("%s could not be found, does not have a corresponding yaml file", new Object[]{locale}));
    } else {
      this.fakeDataMap = (Map) (new Yaml()).load(stream);
    }
  }

  public Locale getLocale() {
    return locale;
  }

  /**
   * Fetch a random value from an array item specified by the key
   *
   * @param key
   * @return
   */
  public Object fetch(String key) {
    List valuesArray = (List) fetchObject(key);
    return valuesArray.get(nextInt(valuesArray.size()));
  }

  /**
   * Same as {@link #fetch(String)} except this casts the result into a String.
   *
   * @param key
   * @return
   */
  public String fetchString(String key) {
    return (String) fetch(key);
  }

  /**
   * Return the object selected by the key from yaml file.
   *
   * @param key key contains path to an object. Path segment is separated by
   *            dot. E.g. name.first_name
   * @return
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object fetchObject(String key) {
    String[] path = key.split("\\.");
    Object currentValue = this.fakeDataMap;
    for (String pathSection : path) {
      currentValue = ((Map<String, Object>) currentValue).get(pathSection);
    }
    return currentValue;
  }

  private int nextInt(int n) {
    return RandomUtils.nextInt(RandomUtils.JVM_RANDOM, n);
  }


  private InputStream findStream(String filename) {
    InputStream streamOnClass = this.getClass().getResourceAsStream("src/main/resources/" + filename);
    return streamOnClass != null ? streamOnClass : this.getClass().getClassLoader().getResourceAsStream(filename);
  }
}
