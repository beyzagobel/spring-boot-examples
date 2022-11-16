package com.beyzagobel.api;

import com.beyzagobel.entity.User;
import com.beyzagobel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApi {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserService userService ;

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser (@RequestBody User user){
        LOG.info("Saving user");
        return userService.createUser(user);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUser (@PathVariable String id){
        LOG.info("Getting user with ID: {}", id);
        return userService.getUser(id);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers (){
        LOG.info("Getting all users.");
        return userService.getAllUsers();
    }

}
