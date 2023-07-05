package middleware.controllers;

import middleware.entity.Log;
import middleware.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/logs")
    public List<Log> getAllLogs() {
        List<Log> logs = cacheService.getAllLogs();
        return logs;
    }

    @PostMapping("/logs")
    public void addLog(@RequestBody Log log) {
        // Add the log to the cache or database
        cacheService.addLog(log);
    }

    @PutMapping("/logs/{logId}")
    public Log updateLogById(@PathVariable String logId, @RequestBody Log updatedLog) {
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
