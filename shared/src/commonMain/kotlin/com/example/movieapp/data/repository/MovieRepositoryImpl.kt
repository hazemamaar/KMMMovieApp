package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.data.util.toMovie
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository


internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {

      return  remoteDataSource.getMovies(page = page) .results.map {
          it.toMovie()
      }
    }

    override suspend fun getMovie(movieId: Int): Movie {

        return remoteDataSource.getMovie(movieId =movieId).toMovie()
    }
}