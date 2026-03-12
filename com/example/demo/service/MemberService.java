package com.example.demo.service;
import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Member saveMember(Member member);

    Page<Member> getAllMembers(Pageable pageable);

    Member getMemberById(Long id);

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);

    Page<Member> searchByName(String name, Pageable pageable);

    Page<Member> getByStatus(String status, Pageable pageable);
}
