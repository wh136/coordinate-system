package com.wh136.xyz.dao;

import com.wh136.xyz.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends CrudRepository<User, Integer> {
    @Query("from User where id =:id ")
    public User getUser(@Param("id") Integer id);
}
