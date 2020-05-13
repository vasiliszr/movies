package com.aueb.movies.model;

public class Bookmarks {

    private int movie_id;
    private int id;

    public Bookmarks(int movie_id, int id) {
        this.movie_id = movie_id;
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bookmarks{" +
                "movie_id=" + movie_id +
                ", id=" + id +
                '}';
    }
}
