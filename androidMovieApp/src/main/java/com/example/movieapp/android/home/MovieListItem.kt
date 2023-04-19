package com.example.movieapp.android.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.domain.model.Movie

@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (Movie) -> Unit,
) {
    Card(modifier = modifier
        .height(220.dp)
        .clickable {
            onMovieClick(movie)
        }, shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(modifier = modifier.weight(1f), contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp)
                        )
                )
                Surface(
                    color = Color.Black.copy(.6f), modifier = modifier
                        .size(50.dp)
                        .clip(
                            CircleShape
                        )
                        .padding(12.dp)
                ) {
                    Image(painter = painterResource(id = com.example.movieapp.android.R.drawable.play_button), contentDescription ="play movie" ,modifier = modifier.align(
                        Alignment.Center
                    ))
                }
            }
            Column(modifier=modifier.padding(10.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = modifier.height(4.dp))
                Text(text = movie.description, style = MaterialTheme.typography.caption)
            }
        }
    }
}