package com.socialmedia.socialmedia.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginDTO {
    private String username ;
    private String password;

    public UserLoginDTO(String username) {
        this.username = username;
    }
}
