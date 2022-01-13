package com.bonsol.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonsol.project.model.Song;
import com.bonsol.project.service.SongService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Song data.")
@RequestMapping("/api")
@RestController
public class SongController {

	@Autowired
	SongService service; 
	
	@GetMapping("/songs")
	public List<Song> getAllSongs(){
		return service.findAllSongs();
	}
	
	
}
