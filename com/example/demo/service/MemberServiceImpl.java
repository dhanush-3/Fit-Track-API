package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
    	member.setJoinDate(LocalDate.now());
        member.setMembershipStatus("ACTIVE");
        return memberRepository.save(member);
    }

    @Override
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
    }

    @Override
    public Member updateMember(Long id, Member updatedMember) {

        Member existing = getMemberById(id);

        existing.setName(updatedMember.getName());
        existing.setEmail(updatedMember.getEmail());
        existing.setPhone(updatedMember.getPhone());

        return memberRepository.save(existing);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Page<Member> searchByName(String name, Pageable pageable) {
        return memberRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Member> getByStatus(String status, Pageable pageable) {
        return memberRepository.findByMembershipStatus(status, pageable);
    }
}