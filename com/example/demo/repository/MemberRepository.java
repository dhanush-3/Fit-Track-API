package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // Pagination
    Page<Member> findAll(Pageable pageable);

    // Search by name
    Page<Member> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Find by membership status
    Page<Member> findByMembershipStatus(String status, Pageable pageable);
}
