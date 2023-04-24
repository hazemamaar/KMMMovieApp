package com.example.movieapp.data.remote

import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MovieService :KtorApi() {
    companion object{
        private const val MOVIES="movie/popular"
        private const val MOVIE="movie/"
    }
    suspend fun getMovies(page: Int = 1): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}