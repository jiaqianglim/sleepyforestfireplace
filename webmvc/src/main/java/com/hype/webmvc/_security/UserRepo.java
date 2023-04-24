package com.hype.webmvc._security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.hype.webmvc._security.model.BasicUser;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate temp;

    public Optional<BasicUser> findUserByEmail(String email) {
        final SqlRowSet rs = temp.queryForRowSet("select * from users where email = ?", email);
        if (rs.next()) {
            return Optional.of(new BasicUser(rs.getString("email"), rs.getString("password"), rs.getString("username"),
                    rs.getString("membership")));
        } else {
            return Optional.empty();
        }
    }

    public boolean saveUser(BasicUser user) {
        int success = temp.update("insert into users values(?,?,?,?)", user.getEmail(), user.getPassword(),
                user.getUsername(), user.getMembership());
        return success > 0;
    }

    public void updateUser(BasicUser user) {
        temp.update("update into users values(?,?,?,?)", user.getEmail(), user.getPassword(),
                user.getUsername(), user.getMembership());
    }

    public void removeUserByEmail(String email) {
        temp.update("delete from users where email = ?", email);
    }
}
