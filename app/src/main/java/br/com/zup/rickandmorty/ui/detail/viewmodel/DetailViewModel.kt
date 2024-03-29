package br.com.zup.rickandmorty.ui.detail.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.domain.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(application: Application):AndroidViewModel(application) {
    private val useCase=CharacterUseCase(application)
    private val _characterResponse = MutableLiveData<RickMortyResult>()
    val characterResponse: LiveData<RickMortyResult> = _characterResponse
    fun updatefavorite(character:RickMortyResult){
        viewModelScope.launch {
            try {
                val response= withContext(Dispatchers.IO){
                    useCase.updatefavorite(character)
                }
                _characterResponse.value = response
            }
            catch (e:Exception){
                Log.i("erro","${e.message}")
            }
        }
    }
}