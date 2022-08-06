package br.com.zup.rickandmorty.data.datasource.local

import androidx.room.*
import br.com.zup.rickandmorty.data.model.RickMortyResult

@Dao
interface CharacterDao {
    @Query("SELECT * FROM tablebd")
    fun getcharactes():List<RickMortyResult>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertcharacter(list: List<RickMortyResult>)
    @Query("SELECT * FROM tablebd WHERE favorite=1")
    fun getfavorite():List<RickMortyResult>
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updatefsvorite(character:RickMortyResult)
}