package com.twlghtzn.workshop.controllers;

import com.twlghtzn.workshop.models.Response;
import com.twlghtzn.workshop.models.Song;
import com.twlghtzn.workshop.models.SongRequest;
import com.twlghtzn.workshop.services.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwesomeController {
  private SongService songService;

  @Autowired
  public AwesomeController(SongService songService) {
    this.songService = songService;
  }

  @RequestMapping(value = "/awesome", method = RequestMethod.GET)
  public ResponseEntity<List<Song>> showAllSongs() {
    return ResponseEntity.status(HttpStatus.OK).body(songService.getAllSongs());
  }

  @PostMapping("/addAwesome")
  public ResponseEntity<Response> addASong(@RequestBody SongRequest songRequest) {
    if (songRequest.getAuthor() == null || songRequest.getTitle() == null
        || songRequest.getGenre() == null || songRequest.getYear() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new Response("Please send song data!"));
    } else {
      songService.addSongFromSongRequest(songRequest);
      return ResponseEntity.status(HttpStatus.OK).body(new Response("Song saved."));
    }
  }
}
