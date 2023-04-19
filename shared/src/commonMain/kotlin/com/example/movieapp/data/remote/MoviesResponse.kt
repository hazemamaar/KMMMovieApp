package com.example.movieapp.data.remote

@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results:List<MovieRemote>
)
