package com.example.movieapp.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private const val BASE_URL ="https://www.themoviedb.org/"
private const val API_KEY ="https://www.themoviedb.org/"
internal abstract class KtorApi {
    val client = HttpClient{
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys =true
                useAlternativeNames =false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path:String){
        url {
            takeFrom(BASE_URL)
            path("3",path)
            parameter("api_ket", API_KEY)
        }
    }
}