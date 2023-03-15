package com.MCT_Rushi.Music.streaming.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogInDto {
    private String userName;
    private String password;
}
