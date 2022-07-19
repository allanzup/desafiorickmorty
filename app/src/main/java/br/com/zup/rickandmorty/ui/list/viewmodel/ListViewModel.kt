package br.com.zup.rickandmorty.ui.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.RickMortyResponse
import br.com.zup.rickandmorty.data.model.RickMortyResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListViewModel:ViewModel() {
    private val _characterResponse=MutableLiveData<List<RickMortyResult>>()
    val characterResponse:LiveData<List<RickMortyResult>> = _characterResponse
    fun getCharacters(){
        try {
            viewModelScope.launch {
                val response= withContext(Dispatchers.IO){
                    RetrofitService.apiService.getCharacter()
                }
                _characterResponse.value = response.results

            }
        }
      catch (e:Exception){

      }
    }
}