package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.TrackRequest;
import com.music.streaming.platform.model.Track;
import com.music.streaming.platform.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {
    private TrackService tService;

    public TrackController(TrackService tService) {
        this.tService = tService;
    }

    @PostMapping
    public Track createNewTrack(@RequestBody TrackRequest request){
        return tService.createTrack(request);
    }

    @GetMapping
    public List<Track> getAllTracks(){
        return tService.getAllTracks();
    }

    @GetMapping("/{tId}")
    public Track getTrackById(@PathVariable Long tId){
        return tService.getTrackById(tId);
    }

    @PutMapping("/{tId}")
    public Track updateTrack(@PathVariable Long tId, @RequestBody TrackRequest request){
        return tService.updateTrack(tId, request);
    }

    @DeleteMapping("/{tId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable Long tId){
        tService.deleteTrack(tId);
    }


}
