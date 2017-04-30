package com.saltside.birds.common.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mukesh.kumar1 on 12/04/17.
 */
public class BirdsResponse {
    private Set<String> items;

    public BirdsResponse() {
        this.items = new HashSet<>();
    }

    public void add(String id) {
        items.add(id);
    }
}
