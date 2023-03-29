package com.togetherness.security.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.togetherness.security.model.UserDTO;
import com.togetherness.security.model.UserEntity;
import com.togetherness.security.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> findAllUsers() {
        return null;
    }

    public UserDTO findUserByUsername(String username) {
        return null;
    }

    public UserDTO findUserById(String id) {
        return null;
    }
/////
    public UserDTO createUser(UserDTO userDTO, String password) throws Exception {
        UserEntity userEntity = new UserEntity(userDTO.getEmail());
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (userRepository.findIfUsernameIsTaken(userDTO.getEmail())) {
            throw new Exception("Email is taken");
        }
        byte[] salt = createSalt();
        byte[] hashedPassword = createPasswordHash(password, salt);
        SecureRandom rand = new SecureRandom();
        String id = Long.valueOf(rand.nextLong(2147483647)).toString();
        userEntity.setId(id);
        userDTO.setId(id);
        userEntity.setStoredSalt(salt);
        userEntity.setStoredHash(hashedPassword);
        userRepository.save(userEntity);
        return userDTO;
    }

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] createPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }
/////
    public void updateUser(String id, UserDTO userDTO, String password) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isEmpty()){
            throw new Exception("No such user found");
        }

    }
/////
    public void removeUserById(String id) throws Exception{
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new Exception("No such user found");
        }
        userRepository.delete(id);
    }
}
