package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private int experienceYears;

    @OneToMany(mappedBy = "trainer")
    @JsonIgnore
    private List<Member> members;

    public Trainer() {}

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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", specialization=" + specialization + ", experienceYears="
				+ experienceYears + ", members=" + members + "]";
	}

    // getters and setters
}