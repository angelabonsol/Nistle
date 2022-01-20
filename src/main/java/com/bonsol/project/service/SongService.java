package com.bonsol.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.bonsol.project.model.Artist;
import com.bonsol.project.model.Song;
import com.bonsol.project.model.Song.Genre;
import com.bonsol.project.repository.ArtistRepository;
import com.bonsol.project.repository.SongRepository;
import com.bonsol.project.exception.ResourceNotFoundException;

@Service
public class SongService {
	
	@Autowired
	SongRepository repo; 
	
	@Autowired
	ArtistRepository aRepo;
	
	//***** Find All Songs *****
	public List<Song> findAllSongs(){
		return repo.findAll();
	}
	
	//CHECK: ***** Find All Songs in Alphabetical ***** ??? 
	public List<Song> findAllSongsAlphabetical(){
		return repo.findAllSongsInOrder();
	}
	
	//CHECK: ***** Find Song by ID *****
	public Song findSongById(Integer id) throws ResourceNotFoundException{
		
		Optional<Song> found = repo.findById(id);
		
		if(found == null) {
			throw new ResourceNotFoundException("Song", id);
		}
				      
		return found.get();
	}
	
	//*****double check 
	//CHECK: ***** Find Songs by Artist ***** 
	public List<Song> findSongsByArtist(String artist) throws ResourceNotFoundException{
		
		//search all artists and get songs
		
		List<Song> results = repo.findAllSongsByArtist(artist);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Song");
		else 
			return results;
		
	}
	
	
	//CHECK: ***** Find Song by Title *****
	public List<Song> findSongsByTitle(String title) throws ResourceNotFoundException{
		List<Song> results = repo.findAllSongsByTitle(title);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Song");
		else 
			return results;
	}
	
	//CHECK: ***** Find Song by Keyword *****
	public List<Song> findSongsByKeyword(String keyword) throws ResourceNotFoundException{
		List<Song> results = repo.findAllSongsByKeyword(keyword);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Song");
		else 
			return results;
		
	}
	
	//CHECK: ***** Find Songs by Genre *****
	public List<Song> findSongsByGenre(Genre genre) throws ResourceNotFoundException{
		List<Song> results = repo.findAllSongsByGenre(genre);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Song");
		else 
			return results;
	}
		
	//CHECK: ***** Create Song ***** 
	public Song createSong(Song song) {
		song.setId(-1);
		
		Song toAdd = repo.save(song);
		
		return toAdd;
		
	}
	
	//CHECK: ***** Remove Song (By Id) *****
	public Song removeSong(Integer id) throws ResourceNotFoundException {
		
		Song toDelete = findSongById(id);
		
		repo.deleteById(id);
		
		return toDelete;
		
	}
	
	//CHECK: ***** Update Song (multiple trait) ***** (Only to be used by Admin) 
	public Song updateSong(Song song) throws ResourceNotFoundException {
		
		if(repo.existsById(song.getId())) {
			Song toUpdate = repo.save(song);
			
			return toUpdate;
		}
		
		throw new ResourceNotFoundException("Song", song.getId());		
	}
	
}



