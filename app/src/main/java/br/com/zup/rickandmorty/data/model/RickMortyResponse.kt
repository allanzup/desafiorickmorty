package br.com.zup.rickandmorty.data.model


import com.google.gson.annotations.SerializedName

data class RickMortyResponse(

    @SerializedName("results")
    var results: List<RickMortyResult> = listOf()
)