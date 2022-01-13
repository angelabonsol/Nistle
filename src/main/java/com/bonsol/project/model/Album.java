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
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "album_id")
	private Integer id;

	@Column(nullable = false)
	private String title; 
	
	@Column(nullable = false)
	private Artist artist;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Song> songs;

	public Album() {
		this(-1, "Untitled", new Artist(), new ArrayList<>());
	}
	
	public Album(Integer id, String title, Artist artist, List<Song> songs) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.songs = songs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artist=" + artist + ", songs=" + songs + "]";
	} 
	
	public String toJson() {
		return  "{\"id\" : " + id + 
				", \"title\" : \"" + title + "\"" + 
				", \"artist\" : \"" + artist + "\"" + 
				", \"songs\" : \"" + songs + "}";	
	}

	
}
