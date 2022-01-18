package com.bonsol.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Artist;
import com.bonsol.project.model.Song;
import com.bonsol.project.model.Song.Genre;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{
	
	@Query("SELECT * FROM nistle.song ORDER BY title")
	List<Song> findAllSongsInOrder();
	
	@Query(value= "SELECT * FROM nistle.song WHERE artist = ?1;")
	List<Song> findAllSongsByArtist(Artist artist);
	
	@Query(value= "SELECT * FROM nistle.song WHERE title = ?1;")
	List<Song> findAllSongsByTitle(String title);
	
	@Query(nativeQuery= true, value= "SELECT * FROM nistle.song WHERE name LIKE ?1;")
	List<Song> findAllSongsByKeyword(String keyword);
	
	@Query(value= "SELECT * FROM nistle.song WHERE genre = ?1;")
	List<Song> findAllSongsByGenre(Genre genre);

}
