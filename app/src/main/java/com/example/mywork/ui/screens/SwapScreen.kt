package com.example.mywork.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SwapScreen( navController: NavHostController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFFecfacf))
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Select your shift you want swap with",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

            }
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item { DayCardSwap("Tue", "23", "10:00 - 13:00", "HMR Clerk") }
                item { DayCardSwap("Thu", "25", "10:00 - 13:00", "Produce Clerk") }
                item { DayCardSwap("Fri", "26", "10:00 - 13:00", "HMR Clerk") }
            }
        }
    }
}

@Composable
fun DayCardSwap(day: String, date: String, time: String?, worker: String?) {
    val showDialog = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(
                RoundedCornerShape(16.dp))
            .clickable(onClick = { showDialog.value = true })
            .background( Color(0xFFecfacf)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
                .width(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                day,
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
            Text(
                date,
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {

                if (time != null && worker != null) {
                    Text(
                        time,
                        modifier = Modifier,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                    Text(
                        worker,
                        modifier = Modifier,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                }
                else {
                    Text(
                        "- No Shift -",
                        modifier = Modifier,
                        color = Color.Black,
                        fontSize = 16.sp,)
                }

            }
            Text(
                "8.00 hr",
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Confirmation") },
            text = { Text("Are you sure you want to request this swap") },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text("CONFIRM")
                }
            }
        )
    }
}