package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.data.repository.MovieRepositoryImpl
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.usecase.GetMovieUseCase
import com.example.movieapp.domain.usecase.GetMoviesUseCase
import com.example.movieapp.util.provideDispatcher
import org.koin.dsl.module

private val dataModule= module {
    factory { RemoteDataSource(get(),get()) }
    factory { MovieService() }
}
private val utilityModule = module {
    factory { provideDispatcher() }
}
private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModule = listOf(domainModule, dataModule, utilityModule)

fun getSharedModule() = sharedModule