package org.weathertracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Value("${spring.application.name}")
  private String applicationName;

  public String getApplicationName() {
    return applicationName;
  }
}
