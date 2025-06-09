package com.example.tallermultiplataforma1.android

import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
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
import androidx.compose.runtime.rememberCoroutineScope
import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
import kotlinx.coroutines.flow.collect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels {
        CharactersViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CharacterListScreen(viewModel)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CharacterListScreen(viewModel: CharactersViewModel) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        var characters by remember { mutableStateOf<List<MarvelCharacter>>(emptyList()) }

        LaunchedEffect(Unit) {
            val (result, source) = viewModel.loadCharacters()
            characters = result
            Toast.makeText(context, source, Toast.LENGTH_SHORT).show()
        }

        Scaffold(containerColor = Color(0xFFBDBDBD),
            topBar = {
                SmallTopAppBar(
                    title = { Text(" Personajes Marvel ",
                        color = Color.White) },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xFF000000) // gris más oscuro
                    ),
                    actions = {
                        Button(onClick = {
                            scope.launch {
                                val (result, source) = viewModel.loadCharacters()
                                characters = result
                                Toast.makeText(context, source, Toast.LENGTH_SHORT).show()
                            }
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF424242)
                            )
                            ) {
                            Text("Actualizar")
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(characters) { character ->
                    CharacterItem(character)
                }
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
                model = character.thumbnailUrl ?: "",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp)
            )
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