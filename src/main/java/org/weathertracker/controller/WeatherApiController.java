package org.weathertracker.controller;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.weathertracker.rest.RestClient;
import org.weathertracker.rest.WeatherResponse;

@Component
public class WeatherApiController {
  private static final Logger LOG = LoggerFactory.getLogger(WeatherApiController.class);
  private final RestClient restClient;

  @Autowired
  public WeatherApiController(RestClient restClient) {
    this.restClient = restClient;
  }

  public void getWeather() throws IOException, InterruptedException {
    LOG.info("Starting getWeather()");
    WeatherResponse response = restClient.callWebService();
    LOG.info("Got weather data for " + response.location().name());
    LOG.info("Ending getWeather()");
  }
}
