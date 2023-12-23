package com.example.itjobstreet

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.itjobstreet.navigation.Screens
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostingLoker1(navController: NavController) {
    // var untuk textfield yang wajib diisi namun tidak terisi
    var errorText by remember { mutableStateOf("") }

    // var value di card perusahaan
    var perusahaanValue by remember { mutableStateOf("") }

    // var value di card posisi
    var posisiValue by remember { mutableStateOf("") }

    // var value di card kriteria
    var kriteria by remember { mutableStateOf("") }


    Scaffold(
        // navbar atas
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2493DC)
                ),
                title = {
                    Text("Tambah Loker",
                            color = Color.White,
                    )
                },
                // icon kembali/back
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White)
                    }
                },
            )
        },
        // navbar bawah
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier
//                    .height(60.dp),
//                containerColor = Color(0xFFE9F4FB),
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//
//                ) {
//                    // tombol untuk lanjut ke halaman field loker selanjutnya
//                    ElevatedButton(
//                        onClick = {
//                            if (perusahaanValue.isEmpty() || posisiValue.isEmpty() || kriteria.isEmpty()) {
//                                errorText = "wajib diisi!"
//                            }else{
//                                navController.navigate(route = Screens.Add2Screen.name)
//                            }
//                        },
//                        colors = ButtonDefaults.buttonColors(Color(0xFF2493DC)),
//                    ) {
//                        Text("Selanjutnya", color = Color.White)
//                    }
//                }
//            }
//        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(16.dp) //padding yang ditulis pada baris pertama modifier = margin
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(
                space = 14.dp
            ),
        ) {
            /* Card Perusahaan */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier
                    .height(108.dp)
//                    .border(1.dp, Color.Red, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
            ) {
                Box(Modifier.fillMaxWidth()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append("Perusahaan") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xffe84642),
                                    fontSize = 18.sp
                                )
                            ) { append("*") }
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    Text(
                        text = errorText,
                        color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }

                // list nama perusahaan untuk dropdown
                val listPerusahaan = listOf(
                    "PT Telkom Indonesia",
                    "PT Telin",
                    "PT Pertamina",
                    "PT Pelabuhan Indonesia",
                    "PT Angkasa Affiniti",
                    "Bank Negara Indonesia (BNI)",
                    "Bank Central Asia (BCA)"
                )

                // dropdown
                var expanded by rememberSaveable { mutableStateOf(false) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    // text field untuk input mencari perusahaan
                    OutlinedTextField(
                        value = perusahaanValue,
                        onValueChange = { newValue ->
                            perusahaanValue = newValue
                        },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        placeholder = {
                            Text("Cari Perusahaan", color = Color.LightGray)
                        },
                        trailingIcon = {
//                            Icon(
//                                Icons.Filled.Search,
//                                contentDescription = "Search",
//                                tint = Color.LightGray,
//                            )
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray,
                            errorContainerColor = Color(0xFFFFF6F6)
                        ),
                        singleLine = true,
                        isError = errorText.isNotEmpty(),
                        modifier = Modifier
                            .padding(7.dp)
                            .height(70.dp)
                            .fillMaxWidth()
                            .menuAnchor(), // menuAnchor modifier must be passed to the text field for correctness
                    )

                    // filter options berdasarkan inputan user di text field
                    val filteringOptions =
                        listPerusahaan.filter { it.contains(perusahaanValue, ignoreCase = true) }
                    if (filteringOptions.isNotEmpty()) {
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            filteringOptions.forEach { pilihPerusahaan ->
                                DropdownMenuItem(
                                    text = { Text(pilihPerusahaan) },
                                    onClick = {
                                        perusahaanValue = pilihPerusahaan
                                        expanded = false
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                )
                            }
                        }
                    }
                }
            }/* End Card Perusahaan */

            /* Card Posisi */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(108.dp)
                    .fillMaxWidth()
            ) {
                Box(Modifier.fillMaxWidth()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append("Posisi") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xffe84642),
                                    fontSize = 18.sp
                                )
                            ) { append("*") }
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    Text(
                        text = errorText,
                        color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }

                // list posisi pekerjaan untuk dropdown
                val listPosisi = listOf(
                    "Project Manager",
                    "Programmer",
                    "Product Design",
                    "UI/UX Programmer",
                    "Front End Programmer"
                )

                // dropdown
                var expanded by rememberSaveable { mutableStateOf(false) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    // text field untuk input memilih posisi pekerjaan
                    OutlinedTextField(
                        value = posisiValue,
                        onValueChange = { newValue ->
                            posisiValue = newValue
                        },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        placeholder = {
                            Text("Posisi Pekerjaan", color = Color.LightGray)
                        },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray,
                            errorContainerColor = Color(0xFFFFF6F6)
                        ),
                        singleLine = true,
                        isError = errorText.isNotEmpty(),
                        modifier = Modifier
                            .padding(7.dp)
                            .height(70.dp)
                            .fillMaxWidth()
                            .menuAnchor(), // menuAnchor modifier must be passed to the text field for correctness
                    )
                    // filter options berdasarkan inputan user di text field
                    val filteringOptions =
                        listPosisi.filter { it.contains(posisiValue, ignoreCase = true) }
                    if (filteringOptions.isNotEmpty()) {
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            filteringOptions.forEach { pilihPosisi ->
                                DropdownMenuItem(
                                    text = { Text(pilihPosisi) },
                                    onClick = {
                                        posisiValue = pilihPosisi
                                        expanded = false
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                )
                            }
                        }
                    }
                }
            } /* End Card Posisi */

            /* Card Kriteria*/
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(108.dp)
                    .fillMaxWidth()
            ) {
                Box(Modifier.fillMaxWidth()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append("Kriteria") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xffe84642),
                                    fontSize = 18.sp
                                )
                            ) { append("*") }
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    Text(
                        text = errorText,
                        color = Color.Red,
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }

                //text field untuk input tambah kriteria
                OutlinedTextField(
                    value = kriteria,
                    onValueChange = { kriteria = it },
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    placeholder = {
                        Text("Kriteria Khusus", color = Color.LightGray)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray,
                        errorContainerColor = Color(0xFFFFF6F6)
                    ),
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Add",
                            tint = Color.LightGray
                        )
                    },
                    singleLine = false,
                    isError = errorText.isNotEmpty(),
                    modifier = Modifier
                        .padding(7.dp)
                        .height(70.dp)
                        .fillMaxWidth()
                )
            }/* End Card Kriteria*/

            /* Card Foto */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(172.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "Foto",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(Alignment.TopStart)
                        )
                        Text(
                            text = "Opsional",
                            color = Color(0xff0033cc).copy(alpha = 0.5f),
                            style = TextStyle(
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(122.dp)
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color(0xffffffff))
                        .border(
                            border = BorderStroke(0.5.dp, Color(0xffbdbdbd)),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 3.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        // akses file image di perangkat pengguna
                        var selectImages by remember { mutableStateOf(listOf<Uri>()) }

                        val galleryLauncher =
                            rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
                                selectImages = it
                            }

                        // icon untuk mengakses file image di perangkat pengguna
                        IconButton(
                            onClick = { galleryLauncher.launch("image/*") },
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    10.dp,
                                    Alignment.CenterHorizontally
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(50.dp))
                                    .background(color = Color(0xffd3e4ff))
                                    .padding(all = 8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.addimage),
                                    contentDescription = "Add image",
                                    tint = Color(0xff001c38),
                                    modifier = Modifier
                                        .size(128.dp)
                                )
                            }
                        }
                        Text(
                            text = "Upload Foto Loker",
                            color = Color.LightGray,
                            style = TextStyle(
                                fontSize = 14.sp
                            ),
                        )
                    }
                }
            } /* End Card Foto */

            /* Card Tanggal */
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .height(108.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tanggal Pendaftaran",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier
                                .align(Alignment.TopStart)
                        )
                        Text(
                            text = "Opsional",
                            color = Color(0xff0033cc).copy(alpha = 0.5f),
                            style = TextStyle(
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        )
                    }
                }

                /* Kalender */
                val calendar = Calendar.getInstance()

                //calendar.set(1990, 0, 22) // year, month, date
                var startDate by remember {
                    mutableLongStateOf(calendar.timeInMillis)
                }

                //calendar.set(1990, 0, 22) // year, month, date
                var endDate by remember {
                    mutableLongStateOf(calendar.timeInMillis)
                }

                // set the initial dates
                val dateRangePickerState = rememberDateRangePickerState(
                    initialSelectedStartDateMillis = startDate,
                    initialSelectedEndDateMillis = endDate
                )

                var showDateRangePicker by remember {
                    mutableStateOf(false)
                }

                if (showDateRangePicker) {
                    DatePickerDialog(
                        onDismissRequest = {
                            showDateRangePicker = false
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    showDateRangePicker = false
                                    startDate = dateRangePickerState.selectedStartDateMillis!!
                                    endDate = dateRangePickerState.selectedEndDateMillis!!
                                }
                            ) {
                                Text(text = "Pilih")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    showDateRangePicker = false
                                }
                            ) {
                                Text(text = "Batal")
                            }
                        }
                    ) {
                        DateRangePicker(
                            state = dateRangePickerState,
                            modifier = Modifier
                                .height(height = 500.dp)
                        )
                    }
                }

                val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                var rangetanggal = "${formatter.format(Date(startDate))} - ${formatter.format(Date(endDate))}"

                //text field untuk input tanggal
                OutlinedTextField(
                    value = rangetanggal,
                    onValueChange = { rangetanggal = it },
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    placeholder = {
                        Text("Pilih Tanggal Pendaftaran", color = Color.LightGray)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray,
                        errorContainerColor = Color(0xFFFFF6F6)
                    ),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                showDateRangePicker = true
                            },
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.kalender),
                                contentDescription = "kalender",
                                colorFilter = ColorFilter.tint(Color(0xffbdbdbd)),
                                modifier = Modifier
                                    .requiredSize(size = 22.dp)
                            )
                        }
                    },
                    readOnly = true,
                    enabled = false,
                    singleLine = true,
                    modifier = Modifier
                        .padding(7.dp)
                        .height(70.dp)
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                showDateRangePicker = true
                            }
                        )
                )
            }/* End Card Tanggal */
        }
    }

}
