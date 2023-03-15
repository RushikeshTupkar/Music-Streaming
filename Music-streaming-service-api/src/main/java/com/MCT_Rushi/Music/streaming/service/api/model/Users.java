package com.MCT_Rushi.Music.streaming.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "firstName is mandatory")
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    private String lastName;

    @NotBlank(message = "userName is mandatory")
    private String userName;

    @NotBlank(message = "password is mandatory")
    private String password;

    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "please provide valid email")
    private String email;

    @NotBlank(message = "phoneNumber is mandatory")
    @Length(min =10, max=10)
    @Pattern(regexp="(0/91)?[7-9][0-9]{9}",  message = "please provide valid phone number")
    private String phoneNumber;

    private String gender;
    private String dateOfBirth;

    private Timestamp createdDate;
    private Timestamp updatedDate;
    @JsonIgnore
    private ArrayList<Integer>playList;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Status status;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Role role;

}
