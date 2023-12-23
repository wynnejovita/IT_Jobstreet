package com.example.itjobstreet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.itjobstreet.navigation.AppNavigation
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITJobstreetTheme {
                AppNavigation()
            }
        }
    }
    //untuk seacrh
    //binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        //override fun onQueryTextSubmit(query: String): Boolean {
           // return false
        }
        //override fun onQueryTextChange(newText: String): Boolean {
           // searchList(newText)
           // return true
       // }
   // }
    //fun searchList(text: String) {
        //val searchList = java.util.ArrayList<DataClass>()
        //for (dataClass in dataList) {
            //if (dataClass.dataTitle?.lowercase()
                    //?.contains(text.lowercase(Locale.getDefault())) == true
            //) {
                //searchList.add(dataClass)
            //}
       // }
       // adapter.searchDataList(searchList)
    //}

