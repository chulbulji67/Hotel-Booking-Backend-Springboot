package com.chulbul.hotelbooking.service.userservice;



import com.chulbul.hotelbooking.entity.User;

import java.util.List;


public interface UserService {



    //Register User
    User registerUsre(User user);

    //getAllUser
    List<User> getAllUser();

    //GET User By Id
    User getUserById(long id);

    String deleteByUserId(long id);

    User updateUser(User user, long id);
}
