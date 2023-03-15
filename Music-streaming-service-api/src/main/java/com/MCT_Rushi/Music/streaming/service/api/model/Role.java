package com.MCT_Rushi.Music.streaming.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Data
@Entity
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @NotBlank(message = "roleDescription is mandatory")
    private String roleDescription;
    @NotBlank(message = "permissoins is/are mandatory")
    private String permissoins;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Users user;


}
