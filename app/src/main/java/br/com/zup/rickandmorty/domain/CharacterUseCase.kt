package br.com.zup.rickandmorty.domain

import android.app.Application
import android.util.Log
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
    suspend fun getfavorite():List<RickMortyResult>{
        return try {
             repository.getfavorite()

        }
        catch (e:Exception){
            Log.i ("erro","${e.message}")
            getcharacterDao()
        }

    }
    suspend fun updatefavorite(character:RickMortyResult):RickMortyResult {
         repository.updatefavorite(character)
        return character
    }
}