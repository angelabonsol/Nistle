package com.bonsol.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonsol.project.exception.ResourceNotFoundException;
import com.bonsol.project.model.Artist;
import com.bonsol.project.service.ArtistService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Artist data.")
@RequestMapping("/api")
@RestController
public class ArtistController {
	
	@Autowired
	ArtistService service;
	
	// ***** Find All Artists    *****
	@GetMapping("/artist")
	public List<Artist> getAllArtists(){
		return service.findAllArtists();
	}
	
	//CHECK: ***** Get All Artists in Alphabetical *****
	@GetMapping("/artist/a-z")
	public List<Artist> getAllSongsInOrder(){
		return service.findAllArtistsAlphabetical();
	}
	
	//CHECK: ***** Get Artist by ID *****
	@GetMapping("/artist/{id}")
	public Artist getSongById(@PathVariable Integer id) throws ResourceNotFoundException{
		return service.findArtistById(id);
	}
		
	//CHECK: ***** Get Artists by Name *****
	@GetMapping("/artist/{name}")
	public List<Artist> getArtistsByName(@PathVariable String name) throws ResourceNotFoundException{
		return service.findArtistsByName(name);
	}
		
	//CHECK: ***** Get Artists by Keyword ***** 
	@GetMapping("/artist/{keyword}")
	public List<Artist> getArtistsByKeyword(@PathVariable String keyword) throws ResourceNotFoundException{
		return service.findArtistsByKeyword(keyword);
	}
		
	//CHECK: ***** Add Artist *****
	@PostMapping("/artist/add")
	public ResponseEntity<Artist> addSong(@RequestBody Artist song){
		
		Artist added = service.createArtist(song);
		
		return new ResponseEntity<Artist>(added, HttpStatus.CREATED);
	}
		
	//CHECK: ***** Delete Artist (By Id) *****
	@DeleteMapping("/artist/delete/{id}")
	public ResponseEntity<Artist> deleteSong(@PathVariable Integer id) throws ResourceNotFoundException{
		
		Artist deleted = service.removeArtist(id);
		
		return new ResponseEntity<Artist>(deleted, HttpStatus.OK);
	}
		
	//CHECK: ***** Update Artist (multiple trait) ***** (Only to be used by Admin)
	@PutMapping("/artist/update/{id}")
	public ResponseEntity<Artist> updateSong(@RequestBody Artist song) throws ResourceNotFoundException{
		
		Artist updated = service.updateArtist(song);
		
		return new ResponseEntity<Artist>(updated, HttpStatus.OK);
	}
		

}
