package com.hype.webmvc._security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hype.webmvc._security.model.BasicUser;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BasicUser createUser(BasicUser user) {

        String result = passwordEncoder.encode(user.getPassword());
        user.setPassword(result);
        boolean success = repo.saveUser(user);
        if (success) {
            user.setPassword("");
            return user;
        } else {
            return null;
        }
    }

    public BasicUser authenticate(String email, String password) {
        if (email.isEmpty() || password.isEmpty())
            throw new BadCredentialsException("Unauthorized");
        BasicUser databaseUser = findUserByEmail(email);
        Boolean correctPassword = verifyPassword(password, databaseUser.getPassword());
        if (!correctPassword) {
            throw new BadCredentialsException("Wrong Password");
        }
        databaseUser.setPassword("");
        return databaseUser;

    }

    public BasicUser findUserByEmail(String email) {
        Optional<BasicUser> user = repo.findUserByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        } else {
            return user.get();
        }

    }

    public void removeUserByEmail(String email) {
        repo.removeUserByEmail(email);
    }

    public void updateUser(BasicUser user) {
        repo.updateUser(user);
    }

    private Boolean verifyPassword(String inputpassword, String databasepassword) {

        String result = passwordEncoder.encode(inputpassword);
        return result.equals(databasepassword);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BasicUser databaseuser = findUserByEmail(email);
        UserDetails user = new User(databaseuser.getEmail(), databaseuser.getPassword(), null);
        return user;
    }
}
