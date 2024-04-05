package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(Color(0xffd2e8d4))
            .padding(horizontal = 20.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(Color(0xff063041))
            ) {
                Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = null)
            }
            Text(
                text = "Dongjun Kim",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontWeight = FontWeight.Bold,
                color = Color(0xff1b7343),
                fontSize = 20.sp
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 50.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            ContactRow(
                imageVector = Icons.Rounded.Call,
                contentDescription = "phone",
                content = "+82 010 5638 3316"
            )
            ContactRow(
                imageVector = Icons.Rounded.Share,
                contentDescription = "share",
                content = "@doonjjun"
            )
            ContactRow(
                imageVector = Icons.Rounded.Email,
                contentDescription = "email",
                content = "doongjun.kim@gmail.com"
            )
        }
    }
}

@Composable
fun ContactRow(
    imageVector: ImageVector,
    contentDescription: String?,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Icon(
            imageVector = imageVector,
            tint = Color(0xFF3ddc84),
            contentDescription = contentDescription
        )
        Text(
            text = content,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}