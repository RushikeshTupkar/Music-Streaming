package com.MCT_Rushi.Music.streaming.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tbl_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @NotBlank(message = "statusName is mandatory")
    private String statusName;
    @NotBlank(message = "statusDescription is mandatory")
    private String statusDescription;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Users user;
//
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Songs song;


}
