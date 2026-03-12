package com.example.demo.service;


import com.example.demo.entity.Subscription;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Member;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private MemberRepository memberRepository;

    

    @Override
    public Subscription createSubscription(Long memberId, Subscription subscription) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(subscription.getDurationInMonths());

        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        subscription.setMember(member);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription getByMemberId(Long memberId) {
        return subscriptionRepository.findByMemberId(memberId)
        		 .orElseThrow(() ->
                 new ResourceNotFoundException("Subscription not found for member id: " + memberId));
    }}
