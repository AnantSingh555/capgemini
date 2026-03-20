package com.cg.dao;

import com.cg.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITraineeRepo extends JpaRepository <Trainee, Integer> {
    public List<Trainee> findByTraineeName(String name);

    public List<Trainee> findAllByTraineeId(int id);
}
