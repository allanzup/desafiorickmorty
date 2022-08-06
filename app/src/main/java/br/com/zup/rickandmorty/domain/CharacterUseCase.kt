package br.com.zup.rickandmorty.domain

import android.app.Application
import br.com.zup.rickandmorty.data.datasource.local.CharacterDataBase
import br.com.zup.rickandmorty.data.model.RickMortyResult

class CharacterUseCase(application: Application) {
    private val characterDao = CharacterDataBase.getCharacterDatabase(application).characterdao()
    private val repository = CharacterRepository(characterDao)
    suspend fun getcharacterDao():List<RickMortyResult>{
        return repository.getcharactrdao()
    }
    suspend fun getcharacternetwork():List<RickMortyResult>{
        return try {
            val response=repository.getcharactnetwork()
            repository.insertcharacterdao(response.results)
            getcharacterDao()
        }
        catch (ex:Exception){
            return getcharacterDao()
        }
    }
}