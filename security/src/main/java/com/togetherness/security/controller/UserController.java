package com.togetherness.security.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.togetherness.security.model.UserDTO;
import com.togetherness.security.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(userService.findUserById(id).toString());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED) 
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException{
        URI uri = new URI("/placeholder");
        return ResponseEntity.created(uri).body("placeholder");
    
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") String id) throws Exception{
        userService.removeUserById(id);
    }

    @PutMapping("/{id}")
    public void putUser(@PathVariable("id") String id, @RequestBody UserDTO userDTO) throws Exception{
        userService.updateUser(id, null, userDTO.getPassword());
    }



}
