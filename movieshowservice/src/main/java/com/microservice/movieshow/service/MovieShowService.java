package com.microservice.movieshow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.movieshow.model.DateMovie;
import com.microservice.movieshow.model.ShowData;
import com.microservice.movieshow.model.ShowDetails;
import com.microservice.movieshow.repository.MovieShowRepo;
import com.microservice.movie.repository.MoviesRepo;
import com.microservice.theatre.repository.ScreenRepo;
import com.microservice.seat.repository.SeatRepo;
import com.microservice.movieshow.modal.MovieShow;
import com.microservice.movie.modal.Movies;
import com.microservice.theatre.modal.Screen;
import com.microservice.seat.modal.Seat;

@Service
public class MovieShowService
{
	@Autowired
	MovieShowRepo movieshowrepo;
	
	@Autowired
	ScreenRepo screenrepo;
	
	@Autowired
	MoviesRepo movierepo;
	
	@Autowired
	SeatRepo seatRepo;
	
	
	public List<ShowData> addShow(List<ShowData> showsdatas) 
	{
		
		for(ShowData showdata : showsdatas) {
			
			MovieShow show = new MovieShow();
			
			show.setDate(showdata.getDate());
			show.setStartTime(showdata.getTime());
			show.setPrice(showdata.getPrice());
			
			Screen screen = screenrepo.getOne(showdata.getScreenid());
			Movies movie = movierepo.getOne(showdata.getMovieid());
			
			show.setScreen(screen);
			show.setMovie(movie);
			
			
			System.out.println(show);
			
			MovieShow movieShowDb = movieshowrepo.save(show);
			
			//Seats :
			for (int j = 1; j <= screen.getTotalNoOfSeats(); j++) 
			{				
				Seat seat = new Seat();
				seat.setSeatNumber(j);
				seat.setScreen(screen);
				seat.setMovieShow(movieShowDb);
				
				seatRepo.save(seat);
			}	

		}
		
		return showsdatas;
	
		
	}


	
	


	public List<Date> searchShowByMovie(Integer movieid) 	//1
	{
		
		List<Date> showsDate = movieshowrepo.findAllByMovie(movieid);
		System.out.println(showsDate);
		
		return showsDate;
		

	}


	public List<ShowDetails> getShowsByMovies(DateMovie datemovie)
	{
		
	//List<show> listOfShow = Search Date AND MovieId :
		List<MovieShow> shows = movieshowrepo.findAllByDateAndMovieid(datemovie.getDate() , datemovie.getMovieid());
		shows.forEach(System.out::println);
			
		List<ShowDetails> showDetails = new ArrayList<>();
		
		System.out.println();
			
		for (MovieShow show : shows) 
		{
			ShowDetails obj = new ShowDetails();
			obj.setShowId(show.getShowId());
			obj.setStartTime(show.getStartTime());
			obj.setScreenid(show.getScreen().getScreenId());
			obj.setPrice(show.getPrice());
			obj.setTheatreName(show.getScreen().getTheatre().getTheatreName());
			obj.setScreenName(show.getScreen().getScreenName());
			
//			System.out.println(show);
//			System.out.println(obj);
			
			showDetails.add(obj);
			
		}
		
		return showDetails;
	
	//
		
	
	}
	

}