package com.example.itjobstreet

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

@Immutable
data class MyItem(val text: String, val isSelected: Boolean = false)
class MyViewLokasi : ViewModel() {

    val list = listOf(
        "Medan, Sumatera Utara", "Banda Aceh, Aceh",
        "Denpasar, Bali", "Jakarta Utara, DKI Jakarta",
        "Jakarta Selatan, DKI Jakarta", "Bandung, Jawa Barat",
        "Jambi, Jambi", "Pontianak, Kalimatan Barat",
        "Batam, Kepulauan Riau", "Ambon, Maluku",
        "Serang, Banten", "Magelang, Jawa Tengah",
        "Bengkulu, Bengkulu"
    )

    val myItems = mutableStateListOf<MyItem>()
        .apply {
            list.forEach {
                add(MyItem(text="$it"))
            }
        }
    fun getSelectedItems() = myItems.filter { it.isSelected }

    fun toggleSelection(index: Int) {

        val item = myItems[index]
        val isSelected = item.isSelected

        if (isSelected) {
            myItems[index] = item.copy(isSelected = false)
        } else {
            myItems[index] = item.copy(isSelected = true)
        }
    }
}