package com.meong.BoardService.User.service;

import com.meong.BoardService.User.dto.UserDTO;
import com.meong.BoardService.User.entity.UserEntity;
import com.meong.BoardService.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> byUserName = userRepository.findByUsername(userDTO.getUsername());
        if(byUserName.isPresent()){
            // 조회 결과 있음
            UserEntity userEntity = byUserName.get();
            if(userEntity.getPassword().equals(userDTO.getPassword())){
                // 비밀번호 일치
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }else {
                // 비밀번호 불일치
                return null;
            }
        }else {
            // 조회 결과 없음
            return null;
        }
    }

    public List<UserDTO> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity: userEntityList){
            userDTOList.add(UserDTO.toUserDTO(userEntity));
//            UserDTO userDTO = UserDTO.toUserDTO(userEntity);
//            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public UserDTO findById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
//            UserEntity userEntity = optionalUserEntity.get();
//            UserDTO userDTO = UserDTO.toUserDTO(userEntity);
//            return userDTO;
            return UserDTO.toUserDTO(optionalUserEntity.get());
        }else {
            return null;
        }
    }

    public UserDTO updeteForm(String myUser) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(myUser);
        if(optionalUserEntity.isPresent()){
            return UserDTO.toUserDTO(optionalUserEntity.get());
        }else {
            return null;
        }
    }

    public void update(UserDTO userDTO) {
        userRepository.save(UserEntity.toUpdateUserEntity(userDTO));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public String userCheck(String username) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);
        if(byUsername.isPresent()){
            // 조회 결과 있음
            return null;
        }else {
            // 조회 결과 없음
            return "ok";
        }
    }
}
