package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProducer userProducer;

    @Transactional
    public UserModel saveUser(UserModel userModel) {
        userModel = userRepository.save(userModel);
        this.userProducer.publishMessageEmail(userModel);

        return userModel;
    }

    @Transactional
    public UserModel getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Transactional
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }
}
