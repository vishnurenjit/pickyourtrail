package com.pickyourtrail.moviedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickyourtrail.moviedb.dto.MovieDto;
import com.pickyourtrail.moviedb.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/api/movies/search/")
	public MovieDto searchMovieData(@RequestParam("Title") String title,
			@RequestParam("page") Integer page) {
		return movieService.searchMovieData(title, page);
	}
}
