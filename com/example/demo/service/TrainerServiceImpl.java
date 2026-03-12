package com.example.demo.service;


import com.example.demo.entity.Trainer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
        		 .orElseThrow(() ->
                 new ResourceNotFoundException("Trainer not found with id: " + id));
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}
