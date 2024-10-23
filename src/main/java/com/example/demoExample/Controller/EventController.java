package com.example.demoExample.Controller;

import com.example.demoExample.Model.Event;
import com.example.demoExample.Service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventService eventService;

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @GetMapping("events/{userId}")
    public ResponseEntity<?> getEvents(@PathVariable int userId) throws Exception {
        List<Event> event=eventService.getUserEvents(userId);
        return new ResponseEntity<>(event,HttpStatus.FOUND);
    }

    @PostMapping("/events")
    public Event  createEvent(@RequestParam String type) {
        return eventService.createEvent(type);
    }
}

