package com.example.demo.service;


import com.example.demo.entity.Attendance;
import java.util.List;

public interface AttendanceService {

    Attendance markAttendance(Long memberId);

    List<Attendance> getAttendanceByMember(Long memberId);
}
