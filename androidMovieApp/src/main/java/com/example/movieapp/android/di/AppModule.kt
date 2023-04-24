package com.example.movieapp.android.di

import com.example.movieapp.android.detail.DetailViewModel
import com.example.movieapp.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel{HomeViewModel(get())}
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}