package com.bonsol.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonsol.project.model.Song;
import com.bonsol.project.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository repo; 
	
	//***** Find All Songs *****
	public List<Song> findAllSongs(){
		return repo.findAll();
	}
	
	//TODO: ***** Find All Songs in Alphabetical ***** ??? 
	
	
	//TODO: ***** Find Song by ID *****
	
	//TODO: ***** Find Songs by Artist *****
	
	//TODO: ***** Find Song by Name *****
	
	//TODO: ***** Find Song by Keyword ***** (Check Group Final Project- Restaurant)
	
	//TODO: ***** Find Songs by Genre *****
		
	//TODO: ***** Create Song *****
	
	//TODO: ***** Remove Song *****
	
	
	//TODO: ***** Update Song (multiple trait) ***** (Only to be used by Admin) 
	
}


