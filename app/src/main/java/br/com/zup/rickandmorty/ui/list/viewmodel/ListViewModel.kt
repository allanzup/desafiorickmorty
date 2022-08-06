package br.com.zup.rickandmorty.ui.list.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import br.com.zup.rickandmorty.data.datasource.local.CharacterDataBase
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.RickMortyResponse
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.domain.CharacterRepository
import br.com.zup.rickandmorty.domain.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val _characterResponse = MutableLiveData<List<RickMortyResult>>()
    val characterResponse: LiveData<List<RickMortyResult>> = _characterResponse
    private val useCase = CharacterUseCase(application)
    fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    useCase.getcharacternetwork()
                }
                _characterResponse.value = response
            } catch (e: Exception) {
                Log.i("erro", "${e.message}")
            }
        }

    }

}