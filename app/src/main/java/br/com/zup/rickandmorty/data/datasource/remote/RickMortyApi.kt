package br.com.zup.rickandmorty.data.datasource.remote

import br.com.zup.rickandmorty.data.model.RickMortyResponse
import retrofit2.http.GET

interface RickMortyApi {
    @GET("character")
   suspend fun getCharacter():RickMortyResponse
}