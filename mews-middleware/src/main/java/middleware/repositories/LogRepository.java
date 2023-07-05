package middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import middleware.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAll();
}
