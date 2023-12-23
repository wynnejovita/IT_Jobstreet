package com.example.itjobstreet.sealed

import com.example.itjobstreet.model.Lowongan

sealed class DataState {
    class Success(val data: MutableList<Lowongan>):DataState()
    class Failed(val message: String):DataState()
    object Loading: DataState()
    object Empty: DataState()
}