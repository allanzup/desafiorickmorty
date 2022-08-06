package br.com.zup.rickandmorty.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.rickandmorty.data.model.RickMortyResult

@Database(entities = [RickMortyResult::class], version = 2)
abstract class CharacterDataBase:RoomDatabase() {
    abstract fun characterdao():CharacterDao
    companion object {
        @Volatile
        private var INSTANCE: CharacterDataBase? = null

        fun getCharacterDatabase(context: Context): CharacterDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDataBase::class.java,
                    "tablebd"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}