package com.aueb.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bookmarks {

    @Id
    @GeneratedValue
    private int movie_id;
    private int id;

    public Bookmarks(int id, int movie_id) {
        this.id = id;
        this.movie_id = movie_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "Bookmarks{" +
                "movie_id=" + movie_id +
                ", id=" + id +
                '}';
    }

}