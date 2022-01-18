package com.bonsol.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Album;
import com.bonsol.project.model.Song;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{
	
	@Query(value= "SELECT * FROM nistle.album WHERE title = ?1;")
	List<Song> findAllAlbumsByTitle(String title);
	
	@Query(value= "SELECT * FROM nistle.album WHERE artist = ?1;")
	List<Song> findAllAlbumsByArtist(String artist);
	
	@Query(nativeQuery= true, value= "SELECT * FROM nistle.album WHERE name LIKE ?1;")
	List<Song> findAllAlbumssByKeyword(String keyword);

}
