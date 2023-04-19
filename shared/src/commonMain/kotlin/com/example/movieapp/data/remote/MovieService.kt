package com.example.movieapp.data.remote

import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MovieService :KtorApi() {
    companion object{
        private const val MOVIES="movies/popular"
        private const val MOVIE="movies/"
    }
    suspend fun getMovies(page:Int =1 ):MoviesResponse =client.get {
        pathUrl(MOVIES)
        parameter("page",page)
    }.body()

    suspend fun getMovie(movieId:Int) :MovieRemote= client.get {
        pathUrl(MOVIE+movieId)
    }.body()
}