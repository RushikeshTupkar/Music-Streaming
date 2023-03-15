package com.MCT_Rushi.Music.streaming.service.api.controller;

import com.MCT_Rushi.Music.streaming.service.api.dto.SongDto;
import com.MCT_Rushi.Music.streaming.service.api.dto.UserDto;
import com.MCT_Rushi.Music.streaming.service.api.model.Songs;
import com.MCT_Rushi.Music.streaming.service.api.repository.ISongRepository;
import com.MCT_Rushi.Music.streaming.service.api.service.SongService;
import com.MCT_Rushi.Music.streaming.service.api.service.UsersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private UsersService usersService;


    @PostMapping("/addAdmin")
    public ResponseEntity<String> addAdmin(@Valid @RequestBody UserDto userDto){
        JSONObject response = usersService.addUser(userDto,"admin");
        if(response.has("errorMessage")){
            return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);
    }



}
