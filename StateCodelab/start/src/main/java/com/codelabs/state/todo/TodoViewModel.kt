/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelabs.state.todo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    //state:todoItems
    var todoItems = mutableStateListOf<TodoItem>()
        private set

    fun addItem(item: TodoItem) {
        todoItems.add(item)
    }

    fun removeItem(item: TodoItem) {
        todoItems.remove(item)
    }

//        private var _todoItems = MutableLiveData(listOf<TodoItem>())
//    val todoItems: LiveData<List<TodoItem>> = _todoItems

//    fun addItem(item: TodoItem) {
//        _todoItems.value = _todoItems.value!! + listOf(item)
//    }
//
//    fun removeItem2(item: TodoItem) {
//        _todoItems.value = _todoItems.value!!.toMutableList().also {
//            it.remove(item)
//        }
//    }
}
