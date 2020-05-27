package com.aueb.movies.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BookmarkID.class)
public class Bookmark {

    @Id
    private int id;

    @Id
    private String movie_id;

    public Bookmark() {}

    public Bookmark(int id, String movie_id) {
        this.id = id;
        this.movie_id = movie_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "movie_id=" + movie_id +
                ", id=" + id +
                '}';
    }

}