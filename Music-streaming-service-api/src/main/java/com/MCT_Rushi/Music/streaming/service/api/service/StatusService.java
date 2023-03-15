package com.MCT_Rushi.Music.streaming.service.api.service;

import com.MCT_Rushi.Music.streaming.service.api.interfaces.ISongServiceInterface;
import com.MCT_Rushi.Music.streaming.service.api.interfaces.IStatusServiceInterface;
import com.MCT_Rushi.Music.streaming.service.api.model.Status;
import com.MCT_Rushi.Music.streaming.service.api.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusServiceInterface {
    @Autowired
    private IStatusRepository iStatusRepository;
    @Override
    public Status addStatus(Status status) {
        return iStatusRepository.save(status);
    }
}
