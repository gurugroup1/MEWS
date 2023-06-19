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
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        MewsConnectorService mewsConnectorService = context.getBean(MewsConnectorService.class);
        mewsConnectorService.addReservation();
        context.close();
    }
}
