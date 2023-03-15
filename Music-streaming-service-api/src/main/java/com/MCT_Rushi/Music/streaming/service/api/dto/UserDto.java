package com.MCT_Rushi.Music.streaming.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
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
    private Integer roleId;
}
