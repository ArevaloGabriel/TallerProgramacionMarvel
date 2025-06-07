package com.example.tallermultiplataforma1.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tallermultiplataforma1.Greeting
import com.example.tallermultiplataforma1.android.ViewModel.CharactersViewModel
import com.example.tallermultiplataforma1.android.ViewModel.CharactersViewModelFactory

import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
import kotlinx.coroutines.flow.collect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels {
        CharactersViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CharacterListScreen(viewModel)
        }
    }

    @Composable
    fun CharacterListScreen(viewModel: CharactersViewModel) {
        var characters by remember { mutableStateOf<List<MarvelCharacter>>(emptyList()) }

        LaunchedEffect(Unit) {
            characters = viewModel.characters()
        }

        LazyColumn {
            items(characters) { character ->
                CharacterItem(character = character)
            }
        }
    }

    @Composable
    fun CharacterItem(character: MarvelCharacter) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = character.thumbnailUrl ?: "", // protección por si es null
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
