package com.example.demoExample.Repo;

import com.example.demoExample.Model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriptionRepo extends JpaRepository<Subscription,Integer> {

    @Query(value = "SELECT * FROM subs WHERE user_id = :userId", nativeQuery = true)
    List<Subscription> findByUserId(@Param("userId") int userId);

}