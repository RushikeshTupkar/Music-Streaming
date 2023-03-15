package com.MCT_Rushi.Music.streaming.service.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SongsDto {

    @NotBlank(message = "songName is mandatory")
    private String songName;
    @NotNull(message = "singer is mandatory")
    private String singer;
    @NotNull(message = "movie name is mandatory/NA")
    private String movie;

    @NotNull(message = "album name is mandatory/NA")
    private String album;

    @NotNull(message = "duartion is mandatory")
    private String duration;

}
