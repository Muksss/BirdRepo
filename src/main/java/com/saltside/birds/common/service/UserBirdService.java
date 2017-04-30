package com.saltside.birds.common.service;

import com.saltside.birds.authservice.AuthService;
import com.saltside.birds.common.dto.BirdsResponse;
import com.saltside.birds.common.exception.BirdException;
import com.saltside.birds.common.model.Bird;
import com.saltside.birds.common.util.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mukesh.kumar1 on 30/04/17.
 */
@Service
public class UserBirdService {
    @Autowired
    private BirdRepositoryService birdRepositoryService;
    @Autowired
    private AuthService authService;

    public Bird add(Bird bird) throws BirdException {
        //validate auth
        Object loggedInUser = authService.getLoggedInUser();

        //Validate
        DataValidator.validate(bird);

        return birdRepositoryService.saveOrUpdate(bird);
    }

    public Bird getBird(String birdId) throws BirdException {
        //validate auth
        Object loggedInUser = authService.getLoggedInUser();

        return birdRepositoryService.getBird(birdId);
    }

    public BirdsResponse getBirds() {
        //validate auth
        Object loggedInUser = authService.getLoggedInUser();

        List<Bird> birds = birdRepositoryService.getBirds();
        BirdsResponse birdsResponse = new BirdsResponse();

        for (Bird bird : birds) {
            birdsResponse.add(bird.getId());
        }

        return birdsResponse;
    }

    public boolean delete(String birdId) {
        //validate auth
        Object loggedInUser = authService.getLoggedInUser();

        try {
            birdRepositoryService.delete(birdId);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
