package com.bonsol.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	@Query("SELECT * FROM nistle.artist ORDER BY name")
	List<Artist> findAllArtistsInOrder();
	
	@Query(value= "SELECT * FROM nistle.artist WHERE name = ?1;")
	List<Artist> findAllArtistsByName(String name);
	
	@Query(nativeQuery= true, value= "SELECT * FROM nistle.artist WHERE name LIKE ?1;")
	List<Artist> findAllArtistsByKeyword(String keyword);
}
