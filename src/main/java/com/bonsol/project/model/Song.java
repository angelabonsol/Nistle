package com.bonsol.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Song {
	
	public enum Genre{
		POP, JAZZ, ROCK, RAP
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "song_id")
	private Integer id;
	
	@Column(nullable = false)
	private String title;

	@ManyToOne
	@JoinColumn(name = "artist_id", referencedColumnName = "id")
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name = "album_id", referencedColumnName = "id")
	private Album album;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genre genre;

	public Song() {
		this (-1, "Untitled", new Artist(), new Album(), Genre.POP);
	}
	
	public Song(Integer id, String title, Artist artist, Album album, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + "]";
	}
	
	public String toJson() {
		return  "{\"id\" : " + id + 
				", \"title\" : \"" + title + "\"" + 
				", \"artist\" : \"" + artist + "\"" + 
				", \"album\" : \"" + album +
				", \"genre\" : \"" + genre + "}";
	}

}
