package com.saltside.birds.common.service;

import com.saltside.birds.common.model.Bird;
import com.saltside.birds.common.repository.BirdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mukesh.kumar1 on 30/04/17.
 *
 * Wrapper service for DB interaction
 *
 */
@Service
public class BirdRepositoryService {

    @Autowired
    private BirdsRepository birdsRepository;


    public Bird saveOrUpdate(Bird bird) {
        if (bird == null) {
            return null;
        }

        return birdsRepository.save(bird);
    }

    public List<Bird> getBirds() {
        return birdsRepository.findByVisible(true);
    }

    public Bird getBird(String birdId) {
        return birdsRepository.findById(birdId);
    }

    public void delete(String id) {
        birdsRepository.delete(Long.parseLong(id));
    }
}
