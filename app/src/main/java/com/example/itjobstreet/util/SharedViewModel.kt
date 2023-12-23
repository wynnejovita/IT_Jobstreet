package com.example.itjobstreet.util

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel(): ViewModel() {
    // This for Save Data (Create & Update)
    fun saveProfileData(
        profileData: ProfileData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch{
            val fireStoreRef = Firebase.firestore
                .collection("User")
                // Jika cek logcat, ini akan error karena UserID tidak ada
                // UserID mungkin baru bisa setelah integrasi database authentication dengan database login
                // Force Close jika function ini dipanggil
                .document(profileData.UserID)

        try {
            fireStoreRef.set(profileData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully saved data", Toast.LENGTH_SHORT).show()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    // This is for get data (Read)
    fun getProfileData(
        UserID: String,
        context: Context,
        data: (ProfileData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("User")
            // UserID bakal error, karena butuh integrasi ke database di authentication
            // Untuk sementara, pakai document = Budi dahulu
            //.document(UserID)
            .document("Budi")

        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        val profileData = it.toObject<ProfileData>()!!
                        data(profileData)
                    } else {
                        Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    // This is for delete data (Delete)
    fun deleteProfileData(
        UserID: String,
        context: Context,
        navController: NavController,
        backToMainScreen: ()  -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("User")
            // Jika cek logcat, ini akan error karena UserID tidak ada
            // UserID mungkin baru bisa setelah integrasi database authentication dengan database login
            // Force Close jika function ini dipanggil
            .document(UserID)

        try {
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully Delete Data", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}

