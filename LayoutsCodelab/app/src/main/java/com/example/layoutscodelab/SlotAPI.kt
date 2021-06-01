package com.example.layoutscodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CallButton() {
    //我们为 Button 提供了一个 API，
    // 它接受一个子可组合 lambda ( content: @Composable () -> Unit)。
    // 这允许您定义自己的可组合对象以在 Button 内发出。
    Button(onClick = { /*TODO*/ }) {
        //content为 的这个 lambda是最后一个参数。
        // 这允许我们使用 尾随 lambda 语法以结构化方式将内容插入到 Button 中。
            Text(text = "test")
    }
}

@Composable
@Preview
fun CallButtonPreView() {
    CallButton()
}

@Composable
fun StatusBar(){
    TopAppBar(
        title = {
            Text(text = "Page title", maxLines = 2)
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.header),
                contentDescription = ""
            )
        }
    )
}
@Composable
@Preview
fun StatusBarPreView(){
    StatusBar()
}