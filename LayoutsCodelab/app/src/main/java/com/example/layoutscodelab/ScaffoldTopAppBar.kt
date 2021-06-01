package com.example.layoutscodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.layoutscodelab.ui.theme.LayoutsCodelabTheme

@Composable
fun LayoutsCodelab() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "LayoutsCodelab")
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            })
    }) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    val nums = remember {
        mutableStateOf(0)
    }
    Column(modifier = modifier) {
        Button(onClick = { nums.value = nums.value + 1 }) {
            Text(text = "Hi there! ${nums.value}")
        }
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreView() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}