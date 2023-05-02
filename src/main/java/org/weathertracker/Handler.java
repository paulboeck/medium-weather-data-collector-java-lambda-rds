/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.weathertracker;

import com.amazonaws.services.lambda.runtime.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

public class Handler {
    private static ConfigurableApplicationContext applicationContext;
    private static Config config;

    static {
        applicationContext = SpringApplication.run(SpringAppForLambda.class);
        config = applicationContext.getBean(Config.class);
    }

    /**
     * Lambda handler method
     * @param context the Lambda request context
     * @return a string containing a message
     */
    public String handleRequest(Context context) {
        return Handler.config.getApplicationName();
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
    }
}
