package org.weathertracker;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * We needed an empty class to serve as the SpringBootApplication because AWS is creating instances
 * of the Handler class and it was creating chaos to have the Handler class also serving as the
 * SpringBootApplication
 */
@SpringBootApplication
public class SpringAppForLambda {
}
