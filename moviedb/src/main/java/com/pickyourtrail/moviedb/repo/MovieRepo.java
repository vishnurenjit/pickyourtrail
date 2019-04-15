package com.pickyourtrail.moviedb.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pickyourtrail.moviedb.entity.Movie;

public interface MovieRepo {

	Page<Movie> findMovieByTitle(String title, PageRequest request);

}
