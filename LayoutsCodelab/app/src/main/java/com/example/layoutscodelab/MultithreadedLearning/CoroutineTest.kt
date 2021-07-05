package com.example.layoutscodelab.MultithreadedLearning

import android.app.DownloadManager
import android.net.Uri
import android.view.ViewGroup
import kotlinx.coroutines.*

suspend fun main() {
    GlobalScope.launch {
        //全局Scope
        val a = add(1, 2)//挂起
        val b = add(4, 5)//挂起
        print(a + b)
    }

//    cancel会报错，因GlobalScope中是EmptyCoroutineContext
//    GlobalScope.cancel()


//    val task = GlobalScope.launch {
//        //全局Scope
//        val a = async { add(1, 2) }
//        val b = async { add(4, 5) }
//        print(a.await() + b.await())
//    }
//    task.cancel()
//
//    val coroutineScope = CoroutineScope(Dispatchers.IO)
//    val job = coroutineScope.launch {
//
//    }
//    job.cancel()
}

suspend fun add(a: Int, b: Int): Int {
    return withContext(Dispatchers.Default) {
        delay(1000)
        a + b
    }
}