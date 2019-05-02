package com.github.mrbean355.android.room.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 2)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    /**
     * Instantiating a database is expensive; implement a Singleton.
     * https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
     */
    companion object {
        @Volatile
        private var instance: PokemonDatabase? = null

        fun getInstance(application: Application): PokemonDatabase {
            val i1 = instance
            if (i1 != null) {
                return i1
            }
            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = Room.databaseBuilder(application, PokemonDatabase::class.java, "pokemon")
                            .fallbackToDestructiveMigration()
                            .build()
                    instance = created
                    created
                }
            }
        }
    }
}