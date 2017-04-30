package com.saltside.birds.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

/**
 * Created by mukesh.kumar1 on 12/04/17.
 */
@Entity(name = "bird")
public class Bird extends TimeStamp {
    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private Set<String> continents;

    @Column
    private boolean visible;

    public Bird(String id, String name, String family, Set<String> continents, boolean visible) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.continents = continents;
        this.visible = visible;
    }

    public Bird(String name, String family, Set<String> continents, boolean visible) {
        this(null, name, family, continents, visible);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Set<String> getContinents() {
        return continents;
    }

    public void setContinents(Set<String> continents) {
        this.continents = continents;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
