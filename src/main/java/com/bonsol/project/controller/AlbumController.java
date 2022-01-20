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
import com.bonsol.project.model.Album;
import com.bonsol.project.service.AlbumService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Album data.")
@RequestMapping("/api")
@RestController
public class AlbumController {
	
	@Autowired
	AlbumService service; 
	
	// ***** Find All Albums *****
	@GetMapping("/album")
	public List<Album> getAllAlbums(){
		return service.findAllAlbums();
	}

	//CHECK: ***** Get All Albums in Chronological Order *****
	@GetMapping("/album/a-z")
	public List<Album> getAllAlbumsInOrder(){
		return service.findAllAlbumsAlphabetical();
	}
	
	//CHECK: ***** Get Album by ID *****
	@GetMapping("/album/{id}")
	public Album getAlbumById(@PathVariable Integer id) throws ResourceNotFoundException{
		return service.findAlbumById(id);
	}
	
	//CHECK: ***** Get Albums by Title *****
	@GetMapping("/album/{title}")
	public List<Album> getAlbumsByTitle(@PathVariable String title) throws ResourceNotFoundException{
		return service.findAlbumsByTitle(title);
	}
	
	//CHECK: ***** Get Albums by Artist *****
	@GetMapping("/album/{artist}")
	public List<Album> getAlbumsByArtist(@PathVariable String artist) throws ResourceNotFoundException{
		return service.findAlbumsByArtist(artist);
	}
	
	//CHECK: ***** Get Albums by Keyword ***** 
	@GetMapping("/album/{keyword}")
	public List<Album> getAlbumsByKeyword(@PathVariable String keyword) throws ResourceNotFoundException{
		return service.findAlbumsByKeyword(keyword);
	}
	
	//CHECK: ***** Add Album *****
	@PostMapping("/album/add")
	public ResponseEntity<Album> addAlbum(@RequestBody Album album){
		
		Album added = service.createAlbum(album);
		
		return new ResponseEntity<Album>(added, HttpStatus.CREATED);
	}
	
	//CHECK: ***** Delete Album (By Id) *****
	@DeleteMapping("/album/delete/{id}")
	public ResponseEntity<Album> deleteAlbum(@PathVariable Integer id) throws ResourceNotFoundException{
		
		Album deleted = service.removeAlbum(id);
		
		return new ResponseEntity<Album>(deleted, HttpStatus.OK);
	}
	
	//CHECK: ***** Update Album (multiple trait) ***** (Only to be used by Admin)
	@PutMapping("/album/update/{id}")
	public ResponseEntity<Album> updateAlbum(@RequestBody Album album) throws ResourceNotFoundException{
		
		Album updated = service.updateAlbum(album);
		
		return new ResponseEntity<Album>(updated, HttpStatus.OK);
	}
	
}
