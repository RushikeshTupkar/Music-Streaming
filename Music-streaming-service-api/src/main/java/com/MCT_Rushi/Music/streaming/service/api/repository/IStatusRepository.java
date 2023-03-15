package com.MCT_Rushi.Music.streaming.service.api.repository;

import com.MCT_Rushi.Music.streaming.service.api.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Integer> {
}
