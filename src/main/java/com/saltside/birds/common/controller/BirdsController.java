package com.saltside.birds.common.controller;

import com.saltside.birds.common.dto.BirdsResponse;
import com.saltside.birds.common.exception.BirdException;
import com.saltside.birds.common.model.Bird;
import com.saltside.birds.common.service.UserBirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by mukesh.kumar on 11/11/16.
 */
@Controller
public class BirdsController {
    @Autowired
    private UserBirdService birdService;

    @RequestMapping(value = "/birds",
                    method = RequestMethod.POST)
    public
    @ResponseBody ResponseEntity addBirds(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "family") String family,
            @RequestParam(value = "visible") boolean visible,
            @RequestParam(value = "continents") Set<String> continents
    ) throws Exception {
        Bird bird = new Bird(name, family, continents, visible);

        try {
            bird = birdService.add(bird);
        } catch (Exception e) {
            return new ResponseEntity(bird, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bird, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/birds",
                    method = RequestMethod.GET)
    public
    @ResponseBody ResponseEntity getBirds() throws Exception {
        BirdsResponse birds = birdService.getBirds();
        return new ResponseEntity(birds, HttpStatus.OK);
    }

    @RequestMapping(value = "/birds/{id}",
                    method = RequestMethod.GET)
    public
    @ResponseBody ResponseEntity getBirdsById(@PathVariable String id) {
        try {
            Bird bird = birdService.getBird(id);
            return new ResponseEntity(bird, HttpStatus.OK);
        } catch (BirdException e) {
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/birds/{id}",
                    method = RequestMethod.DELETE)
    public
    @ResponseBody ResponseEntity deleteBirdsById(@PathVariable String id) throws Exception {
        boolean deleted = birdService.delete(id);
        if (deleted) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}