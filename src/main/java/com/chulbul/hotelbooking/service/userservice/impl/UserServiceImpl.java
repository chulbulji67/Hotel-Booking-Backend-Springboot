package com.chulbul.hotelbooking.service.userservice.impl;


import com.chulbul.hotelbooking.entity.Role;
import com.chulbul.hotelbooking.entity.User;
import com.chulbul.hotelbooking.exception.userexception.UserAlreadyExistException;
import com.chulbul.hotelbooking.exception.userexception.NoUserFoundException;
import com.chulbul.hotelbooking.repository.RoleRepo;
import com.chulbul.hotelbooking.repository.UserRepo;
import com.chulbul.hotelbooking.service.userservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public User registerUsre(User user) {
        //Check if UserAlready Exist
        User existUser = userRepo.findByEmail(user.getEmail());
        if(existUser != null) throw new UserAlreadyExistException("User with This email already exist");
        else {
            existUser = userRepo.findByUsername(user.getUsername());
            if(existUser != null) throw new UserAlreadyExistException("User with This email already exist");
        }

        Set<Role> roles = new HashSet<>();
//        roleRepo.saveAll(roles);

        //now I want Each user role shoud be by default user
        Role role = roleRepo.findById(1L).get();
        //Setting the UserRole
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepo.findAll();
        if(users.isEmpty()) throw new NoUserFoundException("No user Exist");
        return users;
    }

    @Override
    public User getUserById(long id) {
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }
        return userRepo.findById(id).get();
    }

    @Override
    public String deleteByUserId(long id) {
        log.info("Delete User Method is Working");
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }

        userRepo.deleteById(id);
        return "user deleted successfully";
    }

    @Override
    public User updateUser(User user, long id) {
        if(!userRepo.existsById(id)) {
            throw new NoUserFoundException("No user find with id " + id);
        }
        User existingUser = userRepo.findById(id).get();
        existingUser.setId(id);
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());


        return userRepo.save(existingUser);
    }
}
