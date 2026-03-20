package com.cg.service;

import com.cg.dto.TraineeDTO;

import java.util.List;

public interface ITraineeService {
    public TraineeDTO getTrainee(int id);
    public List<TraineeDTO> getAllTrainee();
    public List<TraineeDTO> getTraineeByName(String name);
    public List<TraineeDTO> getTraineeById(int id);
    public TraineeDTO createTrainee(TraineeDTO tDto);
    public String deleteTraineeById(int id);
    public TraineeDTO updateTrainee(TraineeDTO tDto);
}
