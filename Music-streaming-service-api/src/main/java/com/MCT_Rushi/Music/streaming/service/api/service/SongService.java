package com.MCT_Rushi.Music.streaming.service.api.service;

import com.MCT_Rushi.Music.streaming.service.api.dto.SongDto;
import com.MCT_Rushi.Music.streaming.service.api.interfaces.ISongServiceInterface;
import com.MCT_Rushi.Music.streaming.service.api.model.Songs;
import com.MCT_Rushi.Music.streaming.service.api.model.Users;
import com.MCT_Rushi.Music.streaming.service.api.repository.ISongRepository;
import com.MCT_Rushi.Music.streaming.service.api.repository.IStatusRepository;
import com.MCT_Rushi.Music.streaming.service.api.repository.IUsersRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class SongService implements ISongServiceInterface {
    @Autowired
    private ISongRepository iSongRepository;
    @Autowired
    private IStatusRepository iStatusRepository;

    @Autowired
    private IUsersRepository iUsersRepository;
    @Override
    public JSONObject addSong(SongDto songs, String userName, String password) {

        JSONObject jsonObject = new JSONObject();

        List<Users> getUser = iUsersRepository.findByUP(userName,password);
        if(!getUser.isEmpty() && getUser.get(0).getRole().getRoleId()==1){
            Songs newSong = new Songs();
            newSong.setSongName(songs.getSongName());
            newSong.setSinger(songs.getSinger());
            newSong.setMovie(songs.getMovie());
            newSong.setAlbum(songs.getAlbum());
            newSong.setDuration(songs.getDuration());
//            newSong.setStatus(iStatusRepository.findById(1).get());
            iSongRepository.save(newSong);
            jsonObject.put("status","Song saved");
            return jsonObject;
        }
        else if(getUser.isEmpty()){
            jsonObject.put("errormessage","Wrong userName or password   - "+userName+","+password);
            return jsonObject;
        }else{
            jsonObject.put("errormessage","Users are not allowed to add song");
            return jsonObject;
        }
    }
    @Override
    public JSONObject updateSong(SongDto songs, String userName, String password, Integer songId) {
        JSONObject jsonObject = new JSONObject();
        List<Users> getUser = iUsersRepository.findByUP(userName,password);
        Songs newSong = iSongRepository.findById(songId).get();
        if(!getUser.isEmpty() && getUser.get(0).getRole().getRoleId()==1) {
            if (newSong != null) {
                newSong.setSongName(songs.getSongName());
                newSong.setSinger(songs.getSinger());
                newSong.setMovie(songs.getMovie());
                newSong.setAlbum(songs.getAlbum());
                newSong.setDuration(songs.getDuration());
//                newSong.setStatus(iStatusRepository.findById(1).get());
                iSongRepository.save(newSong);
                jsonObject.put("status", "Song saved");
                return jsonObject;
            } else {
                jsonObject.put("errormessage", "Song not found with id - " + songId);
            }
        }else if(getUser.isEmpty()){
            jsonObject.put("errormessage","Wrong userName or password   - "+userName+","+password);
            return jsonObject;
        }else{
            jsonObject.put("errormessage","Users are not allowed to update song");
            return jsonObject;
        }
       return jsonObject;
    }
    @Override
    public JSONArray getSongs() {
        List<Songs> all = iSongRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Songs ele:all){
//            if(ele.getStatus().getStatusId()==1) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("songId", ele.getSongId());
                jsonObject.put("songName", ele.getSongName());
                jsonObject.put("singer", ele.getSinger());
                jsonObject.put("movie", ele.getMovie());
                jsonObject.put("album", ele.getAlbum());
                jsonObject.put("duration", ele.getDuration());
                jsonArray.put(ele.getSongId(),jsonObject);
//            }
        }return jsonArray;
    }

    @Override
    public JSONObject deleteSong(String userName, String password, Integer songId) {
        JSONObject jsonObject = new JSONObject();
        List<Users> getUser = iUsersRepository.findByUP(userName,password);
        Songs newSong = iSongRepository.findById(songId).get();
        if(!getUser.isEmpty() && getUser.get(0).getRole().getRoleId()==1) {
            if (newSong != null) {
//
                iSongRepository.deleteSong(songId);
                jsonObject.put("status", "Song deleted");
                return jsonObject;
            } else {
                jsonObject.put("errormessage", "Song not found with id - " + songId);
            }
        }else if(getUser.isEmpty()){
            jsonObject.put("errormessage","Wrong userName or password   - "+userName+","+password);
            return jsonObject;
        }else{
            jsonObject.put("errormessage","Users are not allowed to delete song");
            return jsonObject;
        }
        return jsonObject;
    }

}
