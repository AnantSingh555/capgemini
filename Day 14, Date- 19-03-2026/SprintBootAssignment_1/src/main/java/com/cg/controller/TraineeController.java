package com.cg.controller;

import com.cg.dto.TraineeDTO;
import com.cg.entity.Trainee;
import com.cg.service.ITraineeService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainees")
public class TraineeController {
    private final ITraineeService tService;

    public TraineeController(ITraineeService tService) {
        this.tService = tService;
    }

    @GetMapping
    public List<TraineeDTO> getAllTrainee(){
        return tService.getAllTrainee();
    }

    @GetMapping("/{tId}")
    public ResponseEntity<List<TraineeDTO>> getAllTraineById(@PathVariable int tId){
        List<TraineeDTO> listT= tService.getTraineeById(tId);
        if(listT!=null){
            return new ResponseEntity<List<TraineeDTO>>(listT, HttpStatus.OK);
        }
        else return new ResponseEntity<List<TraineeDTO>>((List<TraineeDTO>) null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nameIs/{name}")
    public ResponseEntity<List<TraineeDTO>> getAllTraineByName(@PathVariable String name){
        List<TraineeDTO> listT= tService.getTraineeByName(name);
        if(listT!=null){
            return new ResponseEntity<List<TraineeDTO>>(listT, HttpStatus.OK);
        }
        else return new ResponseEntity<List<TraineeDTO>>((List<TraineeDTO>) null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public TraineeDTO insertTrainee(@RequestBody TraineeDTO tDto){
        return tService.createTrainee(tDto);
    }

    @DeleteMapping("/{tId}")
    public String removeTrainee(@PathVariable int tId){
        return tService.deleteTraineeById(tId);
    }

    @PutMapping
    public TraineeDTO updateTrainee(@RequestBody TraineeDTO tDto){
        return tService.updateTrainee(tDto);
    }
}
