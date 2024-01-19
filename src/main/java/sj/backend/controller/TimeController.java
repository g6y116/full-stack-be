package sj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sj.backend.entity.TimeEntity;
import sj.backend.repository.TimeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TimeController {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @GetMapping("/time")
    public String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    }

    @GetMapping("/time/add")
    public String addCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        TimeEntity timeEntity = new TimeEntity(currentTime);
        timeRepository.save(timeEntity);
        return "Current time added to the database.";
    }

    @GetMapping("/time/list")
    public List<TimeEntity> getTimeList() {
        return (List<TimeEntity>) timeRepository.findAll();
    }
}