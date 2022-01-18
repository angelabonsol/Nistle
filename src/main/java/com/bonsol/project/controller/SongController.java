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
import com.bonsol.project.model.Song;
import com.bonsol.project.model.Song.Genre;
import com.bonsol.project.service.SongService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Song data.")
@RequestMapping("/api")
@RestController
public class SongController {

	@Autowired
	SongService service; 
	
	//***** Get All Songs *****
	@GetMapping("/song")
	public List<Song> getAllSongs(){
		return service.findAllSongs();
	}
	
	//CHECK: ***** Get All Songs in Alphabetical ***** ??? 
	@GetMapping("/song/a-z")
	public List<Song> getAllSongsInOrder(){
		return service.findAllSongsAlphabetical();
	}
	
	//CHECK: ***** Get Song by ID *****
	@GetMapping("/song/{id}")
	public Song getSongById(@PathVariable Integer id) throws ResourceNotFoundException{
		return service.findSongById(id);
	}
	
	//double check 
	//CHECK: ***** Get Songs by Artist ***** 
//	@GetMapping("/songs/{artist}")
//	public List<Song> getSongsByArtist(@PathVariable String artist) throws ResourceNotFoundException{
//		return service.findSongsByArtist(artist);
//	}
	
	//CHECK: ***** Get Song by Title *****
	@GetMapping("/song/{title}")
	public List<Song> getSongsByTitle(@PathVariable String title) throws ResourceNotFoundException{
		return service.findSongsByTitle(title);
	}
	
	//CHECK: ***** Get Song by Keyword *****
	@GetMapping("/song/{keyword}")
	public List<Song> getSongsByKeyword(@PathVariable String keyword) throws ResourceNotFoundException{
		return service.findSongsByKeyword(keyword);
	}

	//CHECK: ***** Get Songs by Genre *****
	@GetMapping("/song/{genre}")
	public List<Song> getSongsByGenre(@PathVariable String genre) throws ResourceNotFoundException{
		return service.findSongsByGenre(Genre.valueOf(genre));
	}
	
	//CHECK: ***** Add Song ***** 
	@PostMapping("/song/add")
	public ResponseEntity<Song> addSong(@RequestBody Song song){
		
		Song added = service.createSong(song);
		
		return new ResponseEntity<Song>(added, HttpStatus.CREATED);
	}
	
	
	//CHECK: ***** Delete Song (By Id) *****
	@DeleteMapping("/song/delete/{id}")
	public ResponseEntity<Song> deleteSong(@PathVariable Integer id) throws ResourceNotFoundException{
		
		Song deleted = service.removeSong(id);
		
		return new ResponseEntity<Song>(deleted, HttpStatus.OK);
	}
	
	//CHECK: ***** Update Song (multiple trait) ***** (Only to be used by Admin) 
	@PutMapping("/song/update/{id}")
	public ResponseEntity<Song> updateSong(@RequestBody Song song) throws ResourceNotFoundException{
		
		Song updated = service.updateSong(song);
		
		return new ResponseEntity<Song>(updated, HttpStatus.OK);
	}
	
	
}
