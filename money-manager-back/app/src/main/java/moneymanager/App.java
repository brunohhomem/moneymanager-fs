/*
 * This source file was generated by the Gradle 'init' task
 */
package moneymanager;

import moneymanager.configuration.WebServerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        LOG.info("Starting moneymanager... ");

        SpringApplication.run(WebServerConfiguration.class, args);

        LOG.info("Ending of starting moneymanager... ");
    }
}
