package com.example.demo.controller;

import com.example.demo.entity.Trainer;
import com.example.demo.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{id}")
    public Trainer getTrainer(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "Trainer deleted successfully";
    }
}