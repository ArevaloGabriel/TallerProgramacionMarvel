package com.example.tallermultiplataforma1.Data

import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
import com.example.tallermultiplataforma1.Data.Repository.CharactersRepository
import com.example.tallermultiplataforma1.Data.Utils.Keys.PRIVATE_KEY
import com.example.tallermultiplataforma1.Data.Utils.Keys.PUBLIC_KEY
import java.security.MessageDigest

class CharacterService(private val charactersRepository: CharactersRepository) {

    suspend fun getCharacters(): List<MarvelCharacter> {
        val timestamp = System.currentTimeMillis()
        val hash = md5("$timestamp$PRIVATE_KEY$PUBLIC_KEY")
        val characters = charactersRepository.getCharacters(timestamp, hash)
        return sort(characters)
    }


    private fun md5(string: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(string.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }


    private fun sort(characters: List<MarvelCharacter>): List<MarvelCharacter> {
        return characters.sortedWith(CharacterComparator())
    }

    private class CharacterComparator : Comparator<MarvelCharacter> {
        override fun compare(c1: MarvelCharacter, c2: MarvelCharacter): Int {
            val hasDesc1 = c1.description.isNotEmpty()
            val hasDesc2 = c2.description.isNotEmpty()

            return when {
                hasDesc1 && !hasDesc2 -> -1
                !hasDesc1 && hasDesc2 -> 1
                hasDesc1 && hasDesc2 -> c1.id.compareTo(c2.id)
                else -> c2.id.compareTo(c1.id)
            }
        }
    }
}