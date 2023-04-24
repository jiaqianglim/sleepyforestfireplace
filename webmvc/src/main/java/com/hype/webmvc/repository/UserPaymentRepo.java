package com.hype.webmvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserPaymentRepo{

    @Autowired
    JdbcTemplate temp;

    public void updateUserSubStatus(String email){

    }

}
