package br.com.zup.rickandmorty.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.rickandmorty.data.model.RickMortyResult

@Dao
interface CharacterDao {
    @Query("SELECT * FROM tablebd")
    fun getcharactes():List<RickMortyResult>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertcharacter(list: List<RickMortyResult>)
}