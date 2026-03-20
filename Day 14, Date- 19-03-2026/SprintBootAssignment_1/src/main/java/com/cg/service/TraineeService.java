package com.cg.service;

import com.cg.dao.ITraineeRepo;
import com.cg.dto.EntityMapper;
import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeService implements ITraineeService{
    private final ITraineeRepo repo;

    public TraineeService(ITraineeRepo repo) {
        this.repo = repo;
    }

    @Override
    public TraineeDTO getTrainee(int id) {
        Optional<Trainee> existing=repo.findById(id);
        if(existing.isPresent()){
            return EntityMapper.convertEntityToObject(existing.get());
        }
        return null;

    }

    @Override
    public List<TraineeDTO> getAllTrainee() {
        List<Trainee> trs=repo.findAll();
        List<TraineeDTO> tDTOs=new ArrayList<TraineeDTO>();
        trs.forEach(t->tDTOs.add(EntityMapper.convertEntityToObject(t)));
        return tDTOs;

    }

    @Override
    public List<TraineeDTO> getTraineeByName(String name) {
        List<Trainee> trs=repo.findByTraineeName(name);
        List<TraineeDTO> tDTOs=new ArrayList<TraineeDTO>();
        trs.forEach(t->tDTOs.add(EntityMapper.convertEntityToObject(t)));
        return tDTOs;
    }

    @Override
    public List<TraineeDTO> getTraineeById(int id) {
        List<Trainee> trs=repo.findAllByTraineeId(id);
        List<TraineeDTO> tDTOs=new ArrayList<TraineeDTO>();
        trs.forEach(t->tDTOs.add(EntityMapper.convertEntityToObject(t)));
        return tDTOs;
    }

    @Override
    public TraineeDTO createTrainee(TraineeDTO tDto) {
        Trainee t=repo.saveAndFlush(EntityMapper.convertObjectToEntity(tDto));
        return EntityMapper.convertEntityToObject(t);
    }


    @Override
    public String deleteTraineeById(int id) {
        if(getTrainee(id)!=null){
            repo.deleteById(id);
            return "Trainee Deleted !!!";
        }
        else return null;
    }

    @Override
    public TraineeDTO updateTrainee(TraineeDTO tDto) {
        if(getTrainee(tDto.getTId())!=null){
            Trainee t=repo.saveAndFlush(EntityMapper.convertObjectToEntity(tDto));
            return EntityMapper.convertEntityToObject(t);
        }
        else return null;
    }
}
