package com.saltside.birds.common.repository;

import com.saltside.birds.common.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by simrandeep.singh on 4/19/16.
 */
@Repository
public interface BirdsRepository extends JpaRepository<Bird, Long> {

    Bird findById(String id);

    List<Bird> findByVisible(boolean visible);


}
