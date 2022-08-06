package br.com.zup.rickandmorty.ui.list.viewmodel

import android.app.Application
import androidx.lifecycle.*
import br.com.zup.rickandmorty.data.datasource.local.CharacterDataBase
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.RickMortyResponse
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.domain.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val _characterResponse = MutableLiveData<List<RickMortyResult>>()
    val characterResponse: LiveData<List<RickMortyResult>> = _characterResponse
    private val characterDao = CharacterDataBase.getCharacterDatabase(application).characterdao()
    private val repository = CharacterRepository(characterDao)
    suspend fun getCharacters(): List<RickMortyResult> {
        return try {
            val character = repository.getcharactnetwork()
            repository.insertcharacterdao(character.results)
            getcharacterDao()

        } catch (e: Exception) {
            return getcharacterDao()
        }
    }
    suspend fun getcharacterDao():List<RickMortyResult>{
        return repository.getcharactrdao()
    }
}