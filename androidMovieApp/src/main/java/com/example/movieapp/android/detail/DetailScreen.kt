package com.example.movieapp.android.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.android.R
import com.example.movieapp.android.Red


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailScreenState
) {
    Log.e("detail", "DetailScreen: ${uiState.movie.toString()}", )
    Box(
        contentAlignment = Alignment.Center
    ) {
        uiState.movie?.let { movie ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
            ) {
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = modifier.height(8.dp))

                    Button(
                        onClick = {},
                        modifier = modifier
                            .fillMaxWidth()
                            .height(46.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Red
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.play_button),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = modifier.width(8.dp))

                        Text(text = "Start watching now", color = Color.White)
                    }

                    Spacer(modifier = modifier.height(16.dp))

                    Text(
                        text = "Released in ${movie.releaseDate}".uppercase(),
                        style = MaterialTheme.typography.overline
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(text = movie.description, style = MaterialTheme.typography.body2)
                }
            }
        }

        if (uiState.loading){
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = Red
                )
            }
        }
    }
}