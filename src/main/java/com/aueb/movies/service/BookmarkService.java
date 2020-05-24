package com.aueb.movies.service;

import com.aueb.movies.model.Bookmark;
import com.aueb.movies.repo.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    BookmarkRepository bookmarkRepository;

    public void save(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> findAllById(int id) {
         return bookmarkRepository.findAllById(id);
    }

}