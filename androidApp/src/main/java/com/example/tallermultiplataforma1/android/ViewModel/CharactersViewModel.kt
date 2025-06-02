package com.example.tallermultiplataforma1.android.ViewModel

import androidx.lifecycle.ViewModel


import com.example.tallermultiplataforma1.Data.CharacterService
import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter

class CharactersViewModel(private val characterService: CharacterService) : ViewModel() {



    suspend fun characters():List<MarvelCharacter> {
        return characterService.getCharacters()
    }
}