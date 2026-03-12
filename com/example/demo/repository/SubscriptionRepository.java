package com.example.demo.repository;

import com.example.demo.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByMemberId(Long memberId);
}