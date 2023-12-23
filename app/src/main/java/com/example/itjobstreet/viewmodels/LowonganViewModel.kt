package com.example.itjobstreet.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.itjobstreet.model.Lowongan
import com.example.itjobstreet.sealed.DataState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LowonganViewModel : ViewModel(){
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<Lowongan>()

        response.value = DataState.Loading
        FirebaseDatabase.getInstance().getReference("Lowongan_Pekerjaan")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(DataSnap in snapshot.children){
                        val lowongItem = DataSnap.getValue(Lowongan::class.java)
                        if(lowongItem != null){
                            tempList.add(lowongItem)
                        }
                    }
                    response.value = DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failed(error.message)
                }

            })
    }
}