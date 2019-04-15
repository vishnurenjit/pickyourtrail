package com.pickyourtrail.moviedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pickyourtrail.moviedb.dto.MovieData;
import com.pickyourtrail.moviedb.dto.MovieDto;
import com.pickyourtrail.moviedb.entity.Movie;
import com.pickyourtrail.moviedb.repo.MovieRepo;

@Service
public class MovieService {
	
	private static final int PAGE_SIZE = 5;

	@Autowired
	private MovieRepo movieRepo;
	
	public MovieDto searchMovieData(String title, Integer page) {
		if(page == null) {
			page = 1;
		}
		PageRequest request = PageRequest.of(page, PAGE_SIZE);
		
		Page<Movie> moviePage = movieRepo.findMovieByTitle(title, request);
		
		return buildMovieDTO(moviePage);
	}

	private MovieDto buildMovieDTO(Page<Movie> moviePage) {
		MovieDto dto = new MovieDto();
		dto.setPage(moviePage.getNumber()); 	
		dto.setPerPage(moviePage.getSize());
		dto.setTotalPages(moviePage.getTotalPages());
		dto.setTotal(moviePage.getTotalElements());
		dto.setTotal(moviePage.getTotalElements());
		dto.setData(moviePage.stream().map(this :: buildMovieData).Collect);
		return dto;
	}
	
	private MovieData buildMovieData(Movie movie) {
		MovieData data = new MovieData();
		data.setImdbID(movie.getImdbID());
		data.setPoster(movie.getPoster());
		data.setTitle(movie.getTitle());
		data.setType(movie.getType());
		data.setYear(movie.getYear());
		return data;
	}

}
