package com.socialmedia.socialmedia.mapper;

import com.hm.socialmedia.tables.pojos.User;
import com.socialmedia.socialmedia.dto.UserLoginDTO;
import com.socialmedia.socialmedia.dto.UserSignInDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface UserSignInInfo {

     UserSignInInfo INSTANCE = Mappers.getMapper(UserSignInInfo.class);
     @Mapping(source = "userName", target = "name")
     @Mapping(source = "userAccount", target = "account")
     @Mapping(source = "password", target = "password")
     @Mapping(source = "authority", target = "authority")
     @Mapping(source = "email", target = "email")
     @Mapping(target = "avatar", defaultValue = "null")
//     @Mapping(target = "createdAt", expression ="java(<LocalDateTime.now()>)")
     User userSignInDTOtoUser (UserSignInDTO userSign);

     UserSignInDTO userToUserSignInDTO(User user);
}
