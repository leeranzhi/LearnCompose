package com.example.layoutscodelab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.layoutscodelab.ui.theme.LayoutsCodelabTheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //系统主题更改后，会重新走onCreate方法。
        Log.e(TAG,"onCreate")
        setContent {
            LayoutsCodelabTheme {
                ImageList()
            }
        }
    }
}