package com.MCT_Rushi.Music.streaming.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tbl_songs")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;
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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Status status;

}
