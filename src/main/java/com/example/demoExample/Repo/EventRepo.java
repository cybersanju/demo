package com.example.demoExample.Repo;

import com.example.demoExample.Model.Event;
import com.example.demoExample.Model.Subscription;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepo extends JpaRepository <Event, Long>{


    List<Event> findByEventTypeIn(List<String> subscribedTypes);
}
