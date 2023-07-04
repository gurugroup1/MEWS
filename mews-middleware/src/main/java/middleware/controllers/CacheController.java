package middleware.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.entity.Log;
import middleware.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Component
@RestController
@RequestMapping("/cache")
public class CacheController {
    private final ApplicationContext context;

    @Autowired
    public CacheController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/logs/")

    public List<Log> getAllLogs() {
        CacheService cacheService = context.getBean(CacheService.class);
//
//        // Create a new Log object
//        Log log = new Log();
//        log.setObject("Booker");
//        log.setError("Id not found");
//
//        // Set the JSON payload
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            // Replace jsonString with the provided JSON payload
//            String jsonString = "{\"Client\":\"Thynk 0.1\",\"AccessToken\":\"0F5E505064BC49F1A209AEA0008C938A-24DFA25272C784034F9AD7E3685F4E4\",\"ClientToken\":\"B0602874D5B945C0B12FADEC01068C88-C5ABFC221B4C8AF57C9192C5015A8CD\",\"RateId\":\"bd870c5b-25c6-44c6-9959-acc200fbbd7c\",\"PriceUpdates\":[{\"FirstTimeUnitStartUtc\":\"2024-01-04T23:00:00.000Z\",\"LastTimeUnitStartUtc\":\"2024-01-05T23:00:00.000Z\",\"Value\":222}]}";
//
//            // Truncate the JSON payload if necessary
//            int maxPayloadLength = 255; // Maximum length of the VARCHAR column
//            if (jsonString.length() > maxPayloadLength) {
//                jsonString = jsonString.substring(0, maxPayloadLength);
//            }
//
//            log.setPayload(jsonString);
//        } catch (Exception e) {
//            // Handle any exceptions that occur during JSON parsing or truncation
//            e.printStackTrace();
//        }
//
//        log.setStatus("failed");
//        log.setStatus_code("404");
//
//        cacheService.addLog(log);

        List<Log> logs = cacheService.getAllLogs();

        return logs;
    }
    public void addLog(Log log) {
        // Add the log to the cache or database
        CacheService cacheService = context.getBean(CacheService.class);
        cacheService.addLog(log);
    }

    @PutMapping("/logs/{logId}")
    public Log updateLogById(@PathVariable String logId, @RequestBody Log updatedLog) {
        CacheService cacheService = context.getBean(CacheService.class);

        // Get the log by ID
        Log existingLog = cacheService.getLogById(logId);
        if (existingLog == null) {
            // Log not found
            return null;
        }

        // Update the log properties
        existingLog.setObject(updatedLog.getObject());
        existingLog.setError(updatedLog.getError());
        existingLog.setPayload(updatedLog.getPayload());
        existingLog.setStatus(updatedLog.getStatus());
        existingLog.setStatus_code(updatedLog.getStatus_code());

        // Update the log in the cache
        cacheService.updateLog(existingLog);

        return existingLog;
    }




}
