package middleware.services;

import middleware.entity.Log;
import org.springframework.stereotype.Service;
import middleware.repositories.LogRepository;

import java.util.List;

@Service
public class CacheService {
    private final LogRepository logRepository;

    public CacheService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void addLog(Log log) {
        logRepository.save(log);
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Log getLogById(String logId) {
        return logRepository.findById(Long.valueOf(logId)).orElse(null);
    }
    public void updateLog(Log log) {
        logRepository.save(log);
    }
}
