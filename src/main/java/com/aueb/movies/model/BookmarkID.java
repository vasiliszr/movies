package com.aueb.movies.model;

import java.io.Serializable;

public class BookmarkID implements Serializable {

    private int id;
    private int movie_id;

    public BookmarkID() {}

    public BookmarkID(int id, int movie_id) {
        this.id = id;
        this.movie_id = movie_id;
    }

}
