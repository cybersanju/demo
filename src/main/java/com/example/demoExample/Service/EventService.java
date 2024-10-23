package com.example.demoExample.Service;

import com.example.demoExample.Model.Event;
import com.example.demoExample.Model.Subscription;
import com.example.demoExample.Repo.EventRepo;
import com.example.demoExample.Repo.SubscriptionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    public static final Logger log= LoggerFactory.getLogger(EventService.class);

    @Autowired
    EventRepo eventRepo;
    @Autowired
    SubscriptionRepo subscriptionRepo;


    public List<Event> getUserEvents(Integer userId) {
        List<Subscription> subscriptions = subscriptionRepo.findByUserId(userId);
        List<String> subscribedTypes = subscriptions.stream()
                .filter(subscription -> subscription.getEventType().equals("Art Exhibition"))
                .map(subscription -> subscription.getEventType())
                .collect(Collectors.toList());

        return 	eventRepo.findByEventTypeIn(subscribedTypes);
    }

    public Event createEvent(String type) {
        Event event =new Event();
        event.setEventType(type);
        event.setTimestamp(LocalDate.now());
        return eventRepo.save(event);
    }
}
