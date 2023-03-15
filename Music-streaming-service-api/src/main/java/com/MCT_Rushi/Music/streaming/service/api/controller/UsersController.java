package com.MCT_Rushi.Music.streaming.service.api.controller;

import com.MCT_Rushi.Music.streaming.service.api.dto.LogInDto;
import com.MCT_Rushi.Music.streaming.service.api.dto.UserDto;
import com.MCT_Rushi.Music.streaming.service.api.model.Users;
import com.MCT_Rushi.Music.streaming.service.api.service.SongService;
import com.MCT_Rushi.Music.streaming.service.api.service.UsersService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private SongService songService;
    @PostMapping("/addUser")
    public ResponseEntity<String> addUSer(@Valid @RequestBody UserDto userDto){
        JSONObject response = usersService.addUser(userDto,"user");
        if(response.has("errorMessage")){
            return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);
    }
    @PostMapping("/logIn")
    public ResponseEntity<String> logIn(@RequestBody LogInDto logInDto){
        JSONObject logInStatus = usersService.logIn(logInDto);
        if(logInStatus.has("errorMessage")){
            return new ResponseEntity<>(logInStatus.toString(), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(logInStatus.toString(),HttpStatus.OK);
        }
    }


    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        JSONObject updateStatus = usersService.updateUser(userDto);
        if(updateStatus.has("errorMessage")){
            return new ResponseEntity<>(updateStatus.toString(), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(updateStatus.toString(),HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@NotBlank @RequestParam("userName") String userName,
                                             @NotBlank @RequestParam("password") String password){
        JSONObject jsonObject = usersService.deleteUser(userName, password);
        if(jsonObject.has("errormessage")){
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(@RequestParam Integer userId){
        JSONObject user = usersService.getUser(userId);
        if(user.has("errorMessage")){
            return new ResponseEntity<>(user.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }

    @GetMapping("/getSongs")
    public ResponseEntity<String> getSongs(){
        JSONArray song =songService.getSongs();
        return new ResponseEntity<>(song.toString(), HttpStatus.OK);
    }

    @PostMapping("/addSongsInMyPlayList")
    public ResponseEntity<String> addSongInMyPlayList(@NotBlank  @RequestParam("userName") String userName,
                                                      @NotBlank  @RequestParam("password") String password,
                                                      @NotBlank  @RequestParam("songId") Integer songId){
        JSONObject jsonObject = usersService.addSongInMyPlayList(userName, password, songId, "add");
        if(jsonObject.has("errorMessage")){
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @GetMapping("/getMyPlayList")
    public ResponseEntity<String> getMyPlayList(@NotBlank @RequestParam("userId") Integer user_id){
        JSONArray myPlayList = usersService.getMyPlayList(user_id);
        return new ResponseEntity<>(myPlayList.toString(), HttpStatus.OK);
    }

    @PutMapping("/deleteSongFromMyPlayList")
    public ResponseEntity<String> deleteSongFromPlayList(@NotBlank  @RequestParam("userName") String userName,
                                                         @NotBlank  @RequestParam("password") String password,
                                                         @NotBlank  @RequestParam("songId") Integer songId){
        String command  = "delete";
        JSONObject jsonObject = usersService.deleteFromMyPlayList(userName, password, songId, command);
        if(jsonObject.has("errorMessage")){
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }
}
