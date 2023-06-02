package org.weathertracker.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.weathertracker.Config;

@Component
public class RestClient {
  private static final Logger log = LoggerFactory.getLogger(RestClient.class);
  private final Config config;

  @Autowired
  public RestClient(Config config) {
    this.config = config;
  }

  public WeatherResponse callWebService() throws IOException, InterruptedException {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(java.net.URI.create("https://" + config.getRapidApiHost() + "/history.json?q=53711&dt=" + LocalDate.now().format(formatter)))
        .header("X-RapidAPI-Key", config.getRapidApiKey())
        .header("X-RapidAPI-Host", config.getRapidApiHost())
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    WeatherResponse weatherResponse = new ObjectMapper().readValue(response.body(), WeatherResponse.class);
    if (HttpStatus.OK.value() != response.statusCode()) {
      log.error("Weather API response body:" + response.body());
      throw new RuntimeException("Weather API returned status code " + response.statusCode());
    }
    return weatherResponse;
  }
}

