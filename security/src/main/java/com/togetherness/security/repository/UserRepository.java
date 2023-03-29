package com.togetherness.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.togetherness.security.model.UserDTO;
import com.togetherness.security.model.UserEntity;

@Repository
public class UserRepository {

    public List<UserDTO> findAllUsers(){
        return null;
    }

    public Optional<UserEntity> findByUsername(String username) {
        return null;
    }

    public Boolean findIfUsernameIsTaken(String username) {
        return null;
    }

    public Optional<UserEntity> findById(String Id){
        return null;
    }

    public void save(UserEntity userEntity) {

    }

    public void delete(String id){}
}
