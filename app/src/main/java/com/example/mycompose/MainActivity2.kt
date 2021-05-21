package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp {
                    MyScreenContent()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyComposeTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp)
    )
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    val counterState = remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(
            names = names, Modifier.weight(
                1f
            )
        )

        Counter(count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount })
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    //对状态做出更改，将数据转化为UI
    //将内部状态添加到可组合对象，使用mutableStateOf提供可组合可变存储的函数，
    //如果状态发生变化，将重新组合读取这些字段的composables
//    val count = remember {
//        mutableStateOf(0)
//    }
    //状态提升，Counter的使用者可能对状态感兴趣，故引入update函数作为参数，将其延迟给Counter的调用者
    Button(
        onClick = { updateCount(count + 1) }, colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text(text = "I've been clicked $count times")
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    //LazyColumn 仅渲染屏幕上的可见项，从而在渲染大列表是提高性能。
    //LazyColumn 不会像RecyclerView那样回收children，比Views表现出色
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting2(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Preview("MyScreenContent Preview", showSystemUi = true)
@Composable
fun MyScreenContentPreview() {
    MyApp {
        MyScreenContent()
    }
}

@Preview("Text preview")
@Composable
fun DefaultPreview2() {
    MyApp {
        Greeting2(name = "Android")
    }
}