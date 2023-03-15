package com.MCT_Rushi.Music.streaming.service.api.interfaces;

import com.MCT_Rushi.Music.streaming.service.api.dto.SongDto;
import org.json.JSONArray;
import org.json.JSONObject;

public interface ISongServiceInterface {
    public JSONObject addSong(SongDto songs, String userName, String password);
    public JSONObject updateSong(SongDto songs, String userName, String password, Integer songId);
    public JSONArray getSongs();
    public JSONObject deleteSong(String userName, String password, Integer songId);
}
