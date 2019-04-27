package com.github.mrbean355.android.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonEntity")
    fun getAll(): List<PokemonEntity>

    @Insert
    fun insertAll(items: List<PokemonEntity>)
}