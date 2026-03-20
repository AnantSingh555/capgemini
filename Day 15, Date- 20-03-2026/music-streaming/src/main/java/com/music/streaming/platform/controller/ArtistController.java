package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.ArtistRequest;
import com.music.streaming.platform.model.Artist;
import com.music.streaming.platform.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/platform/v1/artists")
public class ArtistController {
    private ArtistService aService;

    public ArtistController(ArtistService aService) {
        this.aService = aService;
    }

    @GetMapping()
    public List<Artist> getAllArtist(){
        return aService.getAllArtists();
    }

    @GetMapping("/{aId}")
    public Artist getAllArtistById(@PathVariable Long aId){
        return aService.getArtistById(aId);
    }

    @PostMapping
    public Artist createArist(@RequestBody ArtistRequest request){
        return aService.createArtist(request);
    }

    @PutMapping("/{aId}")
    public Artist updateArtist(@PathVariable Long aId, @RequestBody ArtistRequest request){
        return aService.updateArtist(aId, request);
    }

    @DeleteMapping("/{aId}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long aId){
        aService.deleteArtist(aId);
        return ResponseEntity.noContent().build();
    }


}
