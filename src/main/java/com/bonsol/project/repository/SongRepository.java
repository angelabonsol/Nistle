package com.bonsol.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{
	

}
