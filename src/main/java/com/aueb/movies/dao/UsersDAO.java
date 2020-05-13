package com.aueb.movies.dao;

import com.aueb.movies.model.Bookmarks;
import com.aueb.movies.model.Users;

import java.util.List;

public interface UsersDAO {

    public int register(Users users);

    public Users login(int id);

    public int saveBookmark(Bookmarks bookmarks);

    public List<Bookmarks> getBookmarks(int id);

}
