package com.bonsol.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonsol.project.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
