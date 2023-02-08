package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.UserDtoRequest;
import com.example.usermicroservice.dto.UserDtoResponse;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDtoResponse createUser(UserDtoRequest userDtoRequest) {
        User user = mapUserDtoRequestToUser(userDtoRequest);
        userRepository.save(user);
        return mapUserToUserDtoResponse(user);
    }

    public User mapUserDtoRequestToUser(UserDtoRequest userDtoRequest) {
        User user = new User();
        user.setName(userDtoRequest.getName());
        user.setUniqueId(userDtoRequest.getUniqueId());
        user.setEmail(userDtoRequest.getEmail());
        return user;
    }

    public UserDtoResponse mapUserToUserDtoResponse(User user) {
        return new UserDtoResponse(user.getId(), user.getName(), user.getUniqueId(), user.getEmail());
    }

    public UserDtoResponse getUser(String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        return user.isPresent() ? mapUserToUserDtoResponse(user.stream().findFirst().get()) : null;
    }
}
