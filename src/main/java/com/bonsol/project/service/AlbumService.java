package com.bonsol.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonsol.project.exception.ResourceNotFoundException;
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
	
	//CHECK: ***** Find All Albums in Chronological Order *****
	public List<Album> findAllAlbumsAlphabetical(){
		return repo.findAllAlbumsInOrder();
	}
	
	//CHECK: ***** Find Album by ID *****
	public Album findAlbumById(Integer id) throws ResourceNotFoundException{
		
		Optional<Album> found = repo.findById(id);
		
		if(found == null) {
			throw new ResourceNotFoundException("Album", id);
		}
				      
		return found.get();
	}
	
	//CHECK: ***** Find Albums by Title *****
	public List<Album> findAlbumsByTitle(String title) throws ResourceNotFoundException{
		List<Album> results = repo.findAllAlbumsByTitle(title);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Album");
		else 
			return results;
	}
	
	//CHECK: ***** Find Albums by Artist *****
	public List<Album> findAlbumsByArtist(String artist) throws ResourceNotFoundException{
		
	List<Album> results = repo.findAllAlbumsByArtist(artist);
	
	if(results.isEmpty())
		throw new ResourceNotFoundException("Album");
	else 
		return results;
	
}
	
	//CHECK: ***** Find Albums by Keyword *****
	public List<Album> findAlbumsByKeyword(String keyword) throws ResourceNotFoundException{
		List<Album> results = repo.findAllAlbumsByKeyword(keyword);
		
		if(results.isEmpty())
			throw new ResourceNotFoundException("Album");
		else 
			return results;
		
	}
		
	//CHECK: ***** Create Album *****
	public Album createAlbum(Album album) {
		album.setId(-1);
		
		Album toAdd = repo.save(album);
		
		return toAdd;
		
	}
	
	//CHECK: ***** Remove Album (By Id) *****
	public Album removeAlbum(Integer id) throws ResourceNotFoundException {
		
		Album toDelete = findAlbumById(id);
		
		repo.deleteById(id);
		
		return toDelete;
		
	}
	
	
	//CHECK: ***** Update Album (multiple trait) ***** (Only to be used by Admin)
	public Album updateAlbum(Album album) throws ResourceNotFoundException {
		
		if(repo.existsById(album.getId())) {
			Album toUpdate = repo.save(album);
			
			return toUpdate;
		}
		
		throw new ResourceNotFoundException("Album", album.getId());		
	}
	
	
	
	
}
