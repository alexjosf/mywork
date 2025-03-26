package com.example.mywork.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFecfacf))
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Week"
            )
            Text(
                "22/03/2025 - 28/02/2025",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Week"
            )
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item { DayCard("Mon", "22") }
            item { DayCard("Tue", "23") }
            item { DayCard("Wed", "24") }
            item { DayCard("Thu", "25") }
            item { DayCard("Fri", "26") }
            item { DayCard("Sat", "27") }
            item { DayCard("Sun", "28") }
        }
    }
}

@Composable
fun DayCard(day: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                Color(0xFFecfacf),
                RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
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
                Text(
                    "9:00 - 17:00",
                    modifier = Modifier,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
                Text(
                    "HMR Clerk",
                    modifier = Modifier,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            }
            Text(
                "8.00 hr",
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
    }
}