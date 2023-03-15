package com.MCT_Rushi.Music.streaming.service.api.controller;

import com.MCT_Rushi.Music.streaming.service.api.model.Status;
import com.MCT_Rushi.Music.streaming.service.api.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/addStatus")
    public Status  addStatus(@Valid @RequestBody Status status){
        return statusService.addStatus(status);
    }
}
