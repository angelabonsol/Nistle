package com.bonsol.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonsol.project.model.Artist;
import com.bonsol.project.service.ArtistService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Artist data.")
@RequestMapping("/api")
@RestController
public class ArtistController {
	
	@Autowired
	ArtistService service;
	
	@GetMapping("/artists")
	public List<Artist> getAllArtists(){
		return service.findAllArtists();
	}
	
	

}
