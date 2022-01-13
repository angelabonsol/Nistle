package com.bonsol.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonsol.project.model.Album;
import com.bonsol.project.service.AlbumService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Controller for accessing Album data.")
@RequestMapping("/api")
@RestController
public class AlbumController {
	
	@Autowired
	AlbumService service; 
	
	@GetMapping("/albums")
	public List<Album> getAllAlbums(){
		return service.findAllAlbums();
	}

	
	
	
}
