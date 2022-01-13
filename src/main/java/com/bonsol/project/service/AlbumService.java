package com.bonsol.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonsol.project.model.Album;
import com.bonsol.project.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository repo; 
	
	// ***** Find All Albums *****
	public List<Album> findAllAlbums(){
		return repo.findAll();
	}
	
	//TODO: ***** Find All Albums in Alphabetical ***** ??? 
	
	
	//TODO: ***** Find Album by ID *****
	
	//TODO: ***** Find Albums by Name *****
	
	//TODO: ***** Find Albums by Keyword ***** (Check Group Final Project- Restaurant)

	//TODO: ***** Find Albums by Artist *****
		
	//TODO: ***** Create Album *****
	
	//TODO: ***** Remove Album *****
	
	
	//TODO: ***** Update Album (multiple trait) ***** (Only to be used by Admin)
	
	
	
	
	
	
}
