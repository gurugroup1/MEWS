package middleware.controllers;

import middleware.entity.Log;
import middleware.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    public String getAllLogs() {
//        CacheService cacheService = context.getBean(CacheService.class);
//
//        List<Log> logs = cacheService.getAllLogs();
//
//        return logs;
        return "hello";
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
