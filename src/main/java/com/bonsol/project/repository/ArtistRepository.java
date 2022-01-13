package com.bonsol.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	
}
