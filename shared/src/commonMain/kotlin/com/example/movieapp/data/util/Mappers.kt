package com.example.movieapp.data.util

import com.example.movieapp.data.remote.MovieRemote
import com.example.movieapp.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

fun getImageUrl(posterImage: String) = "https://image.tmbd.org/t/p/w500/$posterImage"
