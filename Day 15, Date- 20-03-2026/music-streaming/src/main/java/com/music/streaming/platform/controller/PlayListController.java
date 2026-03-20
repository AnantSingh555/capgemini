package com.music.streaming.platform.controller;


import com.music.streaming.platform.dto.PlayListRequest;
import com.music.streaming.platform.model.PlayList;
import com.music.streaming.platform.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music/platform/v1/playlists")
public class PlayListController {
    private PlayListService pService;

    public PlayListController(PlayListService pService) {
        this.pService = pService;
    }

    @PostMapping
    public PlayList createPlaylist(@RequestBody PlayListRequest request){
        return pService.createPlayList(request);
    }

    @GetMapping("/{pId}")
    public PlayList getPlayListById(@PathVariable Long pId){
        return pService.getPlayListById(pId);
    }

    @DeleteMapping("/{pId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlaylist(@PathVariable Long pId){
        pService.deletePlayList(pId);
    }

}
