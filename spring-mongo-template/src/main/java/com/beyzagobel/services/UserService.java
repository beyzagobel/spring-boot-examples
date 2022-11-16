package com.beyzagobel.services;

import com.beyzagobel.dal.UserDAL;
import com.beyzagobel.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAL userDAL;

    public ResponseEntity<User> createUser(User user){
        return ResponseEntity.ok(userDAL.createUser(user));
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userDAL.getAllUsers());
    }

    public Optional<User> getUser(String id){
        return Optional.ofNullable(userDAL.getUser(id));
    }
}
