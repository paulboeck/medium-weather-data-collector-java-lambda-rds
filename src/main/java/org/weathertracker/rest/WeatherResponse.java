package org.weathertracker.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(Location location, Forecast forecast) {
  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Location(String name, String region, String country, double lat, double lon,
                         String tz_id, long localtime_epoch, String localtime) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Condition(String text, String icon, int code) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Astro(String sunrise, String sunset, String moonrise, String moonset,
                      String moon_phase, String moon_illumination) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Day(double maxtemp_c, double maxtemp_f, double mintemp_c, double mintemp_f,
                    double avgtemp_c, double avgtemp_f, double maxwind_mph, double maxwind_kph,
                    double totalprecip_mm, double totalprecip_in, double avgvis_km,
                    double avgvis_miles, int avghumidity, Condition condition, int uv) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record ForecastDay(String date, long date_epoch, Day day, Astro astro) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Forecast(List<ForecastDay> forecastday) {}

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record WeatherData(Location location, Forecast forecast) {}

}
