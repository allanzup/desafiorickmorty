package br.com.zup.rickandmorty.domain

import br.com.zup.rickandmorty.data.datasource.local.CharacterDao
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.RickMortyResponse
import br.com.zup.rickandmorty.data.model.RickMortyResult

class CharacterRepository(private val characterDao: CharacterDao) {
    suspend fun getcharactnetwork():RickMortyResponse{
        return RetrofitService.apiService.getCharacter()

    }
    suspend fun insertcharacterdao(list: List<RickMortyResult>){
        characterDao.insertcharacter(list)
    }
    suspend fun getcharactrdao():List<RickMortyResult> = characterDao.getcharactes()
    suspend fun getfavorite():List<RickMortyResult> = characterDao.getfavorite()
    suspend fun updatefavorite(character:RickMortyResult){
        characterDao.updatefsvorite(character)
    }
}