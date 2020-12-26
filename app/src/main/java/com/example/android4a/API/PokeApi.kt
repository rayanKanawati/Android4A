package com.example.android4a.API

import com.example.android4a.model.RestPokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PokeApi {

    @GET("pokemon")
    fun getPokemonResponse (): Call<RestPokemonResponse>


}