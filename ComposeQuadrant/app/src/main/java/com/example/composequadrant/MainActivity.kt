package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            Card(
                title = "Text composable",
                content = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF))
            )
            Card(
                title = "Image composable",
                content = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF))
            )
        }
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            Card(
                title = "Row composable",
                content = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8))
            )
            Card(
                title = "Column composable",
                content = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(0.5f)
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun Card(title: String, content: String, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting()
    }
}