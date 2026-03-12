package com.example.demo.controller;



import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/{memberId}")
    public Subscription createSubscription(@PathVariable Long memberId,
                                           @RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(memberId, subscription);
    }

    @GetMapping("/member/{memberId}")
    public Subscription getSubscription(@PathVariable Long memberId) {
        return subscriptionService.getByMemberId(memberId);
    }
}
