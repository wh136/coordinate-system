package com.wh136.xyz.serviceImpl;

import com.wh136.xyz.dao.UserRepository;
import com.wh136.xyz.domain.User;
import com.wh136.xyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Integer id) {
        //有两种方式：
        //1.调用crudRepository的接口
        // return repository.findOne(id);
        //2.调用我们自己写的接口
        return userRepository.getUser(id);
    }
}
