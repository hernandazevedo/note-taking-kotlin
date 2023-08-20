package com.devskiller.notepadplus.presentation

import kotlinx.coroutines.Dispatchers

object CoroutineDispatchers{
    val backgroundThread = Dispatchers.IO
    val mainThread = Dispatchers.Main
}