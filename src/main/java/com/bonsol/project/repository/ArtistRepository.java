package com.bonsol.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Artist;
import com.bonsol.project.model.Song;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	@Query("SELECT * FROM nistle.artist ORDER BY name")
	List<Song> findAllArtistsInOrder();
	
	@Query(value= "SELECT * FROM nistle.artist WHERE name = ?1;")
	List<Song> findAllArtistsByName(String name);
	
	@Query(nativeQuery= true, value= "SELECT * FROM nistle.artist WHERE name LIKE ?1;")
	List<Song> findAllArtistsByKeyword(String keyword);
}
