package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/{memberId}")
    public Attendance markAttendance(@PathVariable Long memberId) {
        return attendanceService.markAttendance(memberId);
    }

    @GetMapping("/member/{memberId}")
    public List<Attendance> getAttendance(@PathVariable Long memberId) {
        return attendanceService.getAttendanceByMember(memberId);
    }
}
