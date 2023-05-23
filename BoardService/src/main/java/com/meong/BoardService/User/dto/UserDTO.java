package com.meong.BoardService.User.dto;

import com.meong.BoardService.User.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    public static UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setNickname(userEntity.getNickname());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }
}
