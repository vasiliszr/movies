package com.aueb.movies.model;

public class Bookmarks {

    private int id;
    private int movie_id;

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
