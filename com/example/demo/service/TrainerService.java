package com.example.demo.service;



import com.example.demo.entity.Trainer;
import java.util.List;

public interface TrainerService {

    Trainer saveTrainer(Trainer trainer);

    List<Trainer> getAllTrainers();

    Trainer getTrainerById(Long id);

    void deleteTrainer(Long id);
}
