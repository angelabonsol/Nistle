package com.bonsol.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonsol.project.exception.ResourceNotFoundException;
import com.bonsol.project.model.Artist;
import com.bonsol.project.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	ArtistRepository repo; 
	
	// ***** Find All Artists    *****
	public List<Artist> findAllArtists(){
		return repo.findAll();
	}
	//TODO: ***** Find All Artists in Alphabetical ***** ??? 
	
	
	//TODO: ***** Find Artist by ID *****
	public Artist findArtistById(Integer id) throws ResourceNotFoundException{
		
		Optional<Artist> found = repo.findById(id);
		
		if(found == null) {
			throw new ResourceNotFoundException("Artist", id);
		}
				      
		return found.get();
	}
	
	//TODO: ***** Find Artists by Name *****
	
	//TODO: ***** Find Artists by Keyword ***** (Check Group Final Project- Restaurant)
		
	//CHECK: ***** Create Artist *****
	public Artist createArtist(Artist artist) {
		artist.setId(-1);
		
		Artist toAdd = repo.save(artist);
		
		return toAdd;
		
	}
	
	//CHECK: ***** Remove Artist (By Id) *****
	public Artist removeArtist(Integer id) throws ResourceNotFoundException {
		
		Artist toDelete = findArtistById(id);
		
		repo.deleteById(id);
		
		return toDelete;
		
	}
	
	//CHECK: ***** Update Artist (multiple trait) ***** (Only to be used by Admin)
	public Artist updateArtist(Artist artist) throws ResourceNotFoundException {
		
		if(repo.existsById(artist.getId())) {
			Artist toUpdate = repo.save(artist);
			
			return toUpdate;
		}
		
		throw new ResourceNotFoundException("Artist", artist.getId());		
	}
	
	//TAKE NOTE: How do you add to Songs per Artist OR Albums per Artist? (Maybe in Controller)

}
