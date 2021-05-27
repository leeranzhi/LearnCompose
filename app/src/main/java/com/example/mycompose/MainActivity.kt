package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
//                NewsStory()
                JetpackCompose()
            }
        }
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "I've been clicked $clicks times")
    }
}

@ExperimentalAnimationApi
@Composable
fun JetpackCompose() {
    Card(Modifier.padding(16.dp)) {
        var expanded by remember {
            mutableStateOf(false)
        }
        Column(
            Modifier
                .clickable { expanded = !expanded }
                .padding(24.dp)) {
            Image(
                painter = painterResource(R.drawable.header),
                contentDescription = "backImage",
                modifier = Modifier
                    .height(180.dp)
                    .width(180.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop,

                )
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = "Jetpack Compose",
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun JetpackPreview() {
    JetpackCompose()
}


@Composable
fun NewsStory() {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "backImage",
            modifier = Modifier
                .height(180.dp)
                .width(180.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        SelectionContainer {
            Text(
                "A day wandering through the sandhills" +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,

                )
        }
        Text(
            "Davenport,California",
            style = typography.body2,
        )
        Text(
            "December 2018",
            style = typography.body2,
        )
    }
}

@Composable
fun DefaultPreview() {
    NewsStory()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
