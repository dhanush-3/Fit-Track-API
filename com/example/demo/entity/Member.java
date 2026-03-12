package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    private LocalDate joinDate;

    private String membershipStatus;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Subscription subscription;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;

    public Member() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", joinDate="
				+ joinDate + ", membershipStatus=" + membershipStatus + ", trainer=" + trainer + ", subscription="
				+ subscription + ", attendanceList=" + attendanceList + "]";
	}

    // getters and setters
    
}