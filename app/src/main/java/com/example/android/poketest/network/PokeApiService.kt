package com.example.android.poketest.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://pokeapi.co/api/v2/"

// Use Retrofit Builder with ScalarsConverterFactory and BaseURL
var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement the PokeApiService interface with @GET getPokemon returning a string
interface PokeApiService {
    @GET()
    fun getPokemon():
            Call<String>
}

// Create the PokeAPi object using Retrofit to implement the PokeApiService
object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}