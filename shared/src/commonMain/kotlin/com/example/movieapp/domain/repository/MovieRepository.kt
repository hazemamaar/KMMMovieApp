package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Movie

internal interface MovieRepository {
     suspend fun getMovies(page: Int): List<Movie>
     suspend fun getMovie(movieId:Int): Movie
}