package com.socialmedia.socialmedia.dto;

import com.socialmedia.socialmedia.validation.ValidEmail;
import com.socialmedia.socialmedia.validation.ValidPassword;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class UserSignInDTO {
    @NotNull
    @Size(min = 1, message = "{Size.userRequest.firstName}")
    private String userName;

    @NotNull
    @Size(min = 1, message = "{Size.userRequest.userAccount}")
    private String userAccount;


    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

   @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private boolean isUsing2FA;
    //    @NotBlank(message = "Email is mandatory")
    private Integer role;
    private String authority;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [userName=")
                .append(userName)
                .append(", email=")
                .append(email)
                .append(", isUsing2FA=")
                .append(isUsing2FA)
                .append(" , authority=")
                .append(authority)
                .append(", role=")
                .append(role).append("]");
        return builder.toString();
    }
}
