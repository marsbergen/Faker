/*
 * Copyright (c) 2015. Collector. You are allowed to re-use this code for free, but please share our product in some way
 * on social media or just share some Collector love with the people that are near to you.
 */

package com.getcollector.faker.service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
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

  public String getString(String module) {
    String[] moduleArr = module.split(".");

    Object data;
    for (String key : moduleArr) {
      data = this.fakeDataMap.get(key);
      System.out.println(data);
    }
    return "{";
  }

  private InputStream findStream(String filename) {
    InputStream streamOnClass = this.getClass().getResourceAsStream("src/main/resources/" + filename);
    return streamOnClass != null ? streamOnClass : this.getClass().getClassLoader().getResourceAsStream(filename);
  }
}
