package com.beyzagobel.service;

import com.beyzagobel.dal.UserDAL;
import com.beyzagobel.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDALImpl implements UserDAL {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User createUser(User user) {
        mongoTemplate.save(user);
        return user;
    }
}
