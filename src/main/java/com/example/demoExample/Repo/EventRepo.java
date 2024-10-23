package com.example.demoExample.Repo;

import com.example.demoExample.Model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository <Event, Long>{


    List<Event> findByEventTypeIn(List<String> subscribedTypes, Pageable pageable);
}
