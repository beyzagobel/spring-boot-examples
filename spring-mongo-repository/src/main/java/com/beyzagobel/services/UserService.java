package com.beyzagobel.services;

import com.beyzagobel.entity.User;
import com.beyzagobel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<User> createUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public Optional<User> getUser(String id){
        return userRepository.findById(id);
    }
}
