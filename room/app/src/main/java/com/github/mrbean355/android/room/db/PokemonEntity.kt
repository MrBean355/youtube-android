package com.github.mrbean355.android.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
        @PrimaryKey(autoGenerate = true) val id: Int,
        val name: String,
        val url: String
)