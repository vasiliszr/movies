package com.aueb.movies.repo;

import com.aueb.movies.model.Bookmark;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {

    List<Bookmark> findAllById(int id);

}
