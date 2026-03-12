package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Create Member
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    // Get All Members with Pagination
    @GetMapping
    public ResponseEntity<Page<Member>> getAllMembers(Pageable pageable) {
        return ResponseEntity.ok(memberService.getAllMembers(pageable));
    }

    // Get Member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    // Update Member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id,
                                               @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    // Delete Member
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully");
    }

    // Search by Name
    @GetMapping("/search")
    public ResponseEntity<Page<Member>> searchByName(@RequestParam String name,
                                                     Pageable pageable) {
        return ResponseEntity.ok(memberService.searchByName(name, pageable));
    }

    // Filter by Status
    @GetMapping("/status")
    public ResponseEntity<Page<Member>> getByStatus(@RequestParam String status,
                                                    Pageable pageable) {
        return ResponseEntity.ok(memberService.getByStatus(status, pageable));
    }
}