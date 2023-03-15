package com.MCT_Rushi.Music.streaming.service.api.repository;

import com.MCT_Rushi.Music.streaming.service.api.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ISongRepository extends JpaRepository<Songs,Integer> {
    @Modifying
    @Transactional
    @Query(value = "Update tbl_songs set status_statusId = 2 where songId = :songId", countQuery = "Select count(*) From tbl_songs", nativeQuery = true)
     public  void deleteSong(Integer songId);
}
