/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.weathertracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppTest {

    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void testHandleRequest() {
        App app = new App();
        Context context = Mockito.mock(Context.class);
        assertTrue(app.handleRequest(context).startsWith("Hello World!"));

    }
}
