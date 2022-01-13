package com.bonsol.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "artist_id")
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Album> albums; 
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Song> songs;

	public Artist() {
		this(-1, "Untitled", new ArrayList<>(), new ArrayList<>());
	}
	
	public Artist(Integer id, String name, List<Album> albums, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.songs = songs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", albums=" + albums + ", songs=" + songs + "]";
	} 

	public String toJson() {
		return  "{\"id\" : " + id + 
				", \"name\" : \"" + name + "\"" + 
				", \"albums\" : \"" + albums + "\"" + 
				", \"songs\" : \"" +songs + "}";	
	}
	
}
