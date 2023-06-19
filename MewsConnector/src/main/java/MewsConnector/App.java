package MewsConnector;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.services.MewsConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
    @Autowired
    private ApplicationConfiguration applicationConfiguration;
    public static void main(String[] args) {
        // Create the Spring Boot application context
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        // Get an instance of the MewsConnectorService bean
        MewsConnectorService mewsConnectorService = context.getBean(MewsConnectorService.class);

        // Call the addReservation method
        mewsConnectorService.addReservation();

        // Close the application context
        context.close();
    }
}
