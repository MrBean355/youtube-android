package com.github.mrbean355.android.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.mrbean355.android.databinding.databinding.ActivityCreatePokemonBinding

/**
 * Whoops! The original idea was to have an activity to create new Pokemon (hence the file naming).
 * When making my video, I completely forgot about this!
 * Oh well, the code principles stay the same :D
 */
class CreatePokemonActivity : AppCompatActivity() {
    private lateinit var viewModel: CreatePokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = CreatePokemonViewModel()
        val binding = DataBindingUtil.setContentView<ActivityCreatePokemonBinding>(this, R.layout.activity_create_pokemon)
        binding.viewModel = viewModel
        binding.setOnButtonClicked {
            Toast.makeText(this, R.string.test_button_clicked, Toast.LENGTH_SHORT).show()
        }

        viewModel.update()
    }
}