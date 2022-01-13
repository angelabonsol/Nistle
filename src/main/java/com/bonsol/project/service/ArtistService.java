package com.bonsol.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	//TODO: ***** Find Artists by Name *****
	
	//TODO: ***** Find Artists by Keyword ***** (Check Group Final Project- Restaurant)
		
	//TODO: ***** Create Artist *****
	
	//TODO: ***** Remove Artist *****
	
	
	//TODO: ***** Update Artist (multiple trait) ***** (Only to be used by Admin)
	
	//TAKE NOTE: How do you add to Songs per Artist OR Albums per Artist? (Maybe in Controller)

}
