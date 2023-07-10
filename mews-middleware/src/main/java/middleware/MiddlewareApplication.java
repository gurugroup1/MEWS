package middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MiddlewareApplication {
    private static final Logger logger = LoggerFactory.getLogger(MiddlewareApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Middleware Application...");
        SpringApplication.run(MiddlewareApplication.class, args);
        logger.info("Middleware Application started successfully.");
    }
}
