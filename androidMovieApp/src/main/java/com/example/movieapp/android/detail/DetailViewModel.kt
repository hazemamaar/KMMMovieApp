package com.example.movieapp.android.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(val getMovieUseCase: GetMovieUseCase,val movieId:Int) :ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)

    }

    private fun loadMovie(movieId: Int){
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val movie = getMovieUseCase(movieId = movieId)
                Log.e("detailvieModel", "DetailScreen: ${movie}", )
                uiState.copy(loading = false, movie = movie)
            }catch (error: Throwable){
                uiState.copy(
                    loading = false,
                    errorMessage = "Could not load the movie"
                )
            }
        }
    }
}

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)