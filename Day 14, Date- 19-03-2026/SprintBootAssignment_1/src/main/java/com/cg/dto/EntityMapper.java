package com.cg.dto;

import com.cg.entity.Trainee;

public class EntityMapper {
    public static Trainee convertObjectToEntity(TraineeDTO tDto){
        return new Trainee(tDto.getTName(), tDto.getTDomain(), tDto.getTLocation());
    }
    public static TraineeDTO convertEntityToObject(Trainee t){
        return new TraineeDTO(t.getTraineeId(), t.getTraineeName(), t.getTraineeDomain(), t.getTraineeLocation());
    }
}
