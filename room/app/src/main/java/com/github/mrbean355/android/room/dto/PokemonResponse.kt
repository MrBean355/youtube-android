package com.github.mrbean355.android.room.dto

data class PokemonResponse(
        val count: Int,
        val results: List<Pokemon>
)