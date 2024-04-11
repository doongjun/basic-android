package com.example.artspace

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_MOVE) {

        }

        return super.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        var currentAlbumIndex by remember { mutableIntStateOf(1) }
        var currentArtIndex by remember { mutableIntStateOf(0) }
        val album = albums[currentAlbumIndex]
        val art = album.arts[currentArtIndex]

        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Surface(
                shadowElevation = 10.dp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(vertical = 80.dp)
                    .weight(6f),
            ) {
                Image(
                    painter = painterResource(art.image),
                    contentDescription = stringResource(art.imageDescription),
                    modifier = Modifier.padding(30.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .weight(1.5f)
                    .background(Color(0xFFECEBF3))
            ) {
                Text(text = stringResource(art.title), fontSize = 30.sp, modifier = Modifier.padding(22.dp))
                Row {
                    Text(text = stringResource(art.description), fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 22.dp, bottom = 22.dp))
                    Text(text = "(${stringResource(art.year)})", modifier = Modifier.padding(start = 5.dp, end = 22.dp))
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Button(
                    onClick = { currentArtIndex = getPrevIndex(currentArtIndex, album.arts.size) },
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Previous")
                }
                Button(
                    onClick = { currentArtIndex = getNextIndex(currentArtIndex, album.arts.size) },
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 1500
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}

private fun getPrevIndex(
    currentIndex: Int,
    size: Int
): Int {
    return when (currentIndex) {
        in 1..<size -> currentIndex - 1
        else -> size - 1
    }
}

private fun getNextIndex(
    currentIndex: Int,
    size: Int
): Int {
    return when (currentIndex) {
        in 0..<size - 1 -> currentIndex + 1
        else -> 0
    }
}

data class Art(
    @DrawableRes
    val image: Int,
    @StringRes
    val imageDescription: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
    @StringRes
    val year: Int
)

data class Album(
    val arts: List<Art>
) {
    companion object {
        fun of(): Album {
            return Album(
                listOf(
                    Art(
                        image = R.drawable.bukayo,
                        imageDescription = R.string.bukayo_image_description,
                        title = R.string.bukayo_title,
                        description = R.string.bukayo_description,
                        year = R.string.bukayo_year
                    ),
                    Art(
                        image = R.drawable.horse,
                        imageDescription = R.string.horse_image_description,
                        title = R.string.horse_title,
                        description = R.string.horse_description,
                        year = R.string.horse_year
                    )
                )
            )
        }

        fun ofLogo(): Album {
            return Album(
                listOf(
                    Art(
                        image = R.drawable.arsenal,
                        imageDescription = R.string.arsenal_image_description,
                        title = R.string.arsenal_title,
                        description = R.string.arsenal_description,
                        year = R.string.arsenal_year
                    ),
                    Art(
                        image = R.drawable.arsenal_fc,
                        imageDescription = R.string.arsenal_fc_image_description,
                        title = R.string.arsenal_fc_title,
                        description = R.string.arsenal_fc_description,
                        year = R.string.arsenal_fc_year
                    ),
                    Art(
                        image = R.drawable.awslogo,
                        imageDescription = R.string.aws_image_description,
                        title = R.string.aws_title,
                        description = R.string.aws_description,
                        year = R.string.aws_year
                    ),
                    Art(
                        image = R.drawable.android_logo,
                        imageDescription = R.string.android_image_description,
                        title = R.string.android_title,
                        description = R.string.android_description,
                        year = R.string.android_year
                    ),
                    Art(
                        image = R.drawable.purpleworks,
                        imageDescription = R.string.purpleworks_image_description,
                        title = R.string.purpleworks_title,
                        description = R.string.purpleworks_description,
                        year = R.string.purpleworks_year
                    ),
                )
            )
        }
    }
}

val albums: List<Album> = listOf(
    Album.of(), Album.ofLogo()
)