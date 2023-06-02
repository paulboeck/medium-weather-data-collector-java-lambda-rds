package org.weathertracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Value("${spring.application.name}")
  private String applicationName;
  @Value("${rapidapi.key}")
  private String rapidApiKey;
  @Value("${rapidapi.host}")
  private String rapidApiHost;

  public String getApplicationName() {
    return applicationName;
  }

  public String getRapidApiKey() {
    return rapidApiKey;
  }

  public String getRapidApiHost() {
    return rapidApiHost;
  }

  @Override
  public String toString() {
    return "Config{" +
        "applicationName='" + applicationName + '\'' +
        ", rapidApiKey='" + rapidApiKey + '\'' +
        ", rapidApiHost='" + rapidApiHost + '\'' +
        '}';
  }
}
