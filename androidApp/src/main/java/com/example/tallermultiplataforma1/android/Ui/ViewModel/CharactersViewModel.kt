package com.example.tallermultiplataforma1.android.Ui.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tallermultiplataforma1.android.Data.Api.CharactersService
import com.example.tallermultiplataforma1.android.Data.Model.Character

class CharactersViewModel(private val charactersService: CharactersService) : ViewModel() {



    suspend fun characters():List<Character> {
        return charactersService.getCharacters()
    }
}