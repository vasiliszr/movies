package com.aueb.movies.model;

import java.io.Serializable;
import java.util.Objects;

public class BookmarkID implements Serializable {

    private int id;
    private String movie_id;

    public BookmarkID() {}

    public BookmarkID(int id, String movie_id) {
        this.id = id;
        this.movie_id = movie_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookmarkID that = (BookmarkID) o;
        return id == that.id && movie_id.equals(that.movie_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie_id);
    }
}
