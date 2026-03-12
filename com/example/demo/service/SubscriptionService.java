package com.example.demo.service;
import com.example.demo.entity.Subscription;

public interface SubscriptionService {

    Subscription createSubscription(Long memberId, Subscription subscription);

    Subscription getByMemberId(Long memberId);
}