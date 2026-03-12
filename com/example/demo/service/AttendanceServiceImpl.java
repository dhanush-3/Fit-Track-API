package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Member;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Attendance markAttendance(Long memberId) {

        Member member = memberRepository.findById(memberId)
        		.orElseThrow(() -> new ResourceNotFoundException("Member Attendence not found with id: " + memberId));

        Attendance attendance = new Attendance();
        attendance.setCheckInTime(LocalDateTime.now());
        attendance.setMember(member);

        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByMember(Long memberId) {
        return attendanceRepository.findByMemberId(memberId);
    }
}