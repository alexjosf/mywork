package com.example.mywork.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mywork.ui.components.NameCard

@Composable
fun ScheduleScreen(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AdaptiveGrid(navController)
        }
    }
}

@Composable
fun AdaptiveGrid(navController: NavHostController) {
    val data = listOf(
        listOf(
            "Alice Johnson",
            "8:30 - 16:30",
            null,
            "10:00 - 18:00",
            null,
            "12:00 - 20:00",
            "8:00 - 16:00",
            null
        ),
        listOf(
            "Bobby Chang",
            "7:00 - 15:00",
            "9:00 - 17:00",
            null,
            null,
            "8:30 - 16:30",
            "11:00 - 19:00",
            null
        ),
        listOf(
            "Charlie Peterson",
            "10:00 - 18:00",
            null,
            null,
            "12:00 - 20:00",
            "7:00 - 15:00",
            null,
            "9:30 - 17:30"
        ),
        listOf(
            "David Lewis",
            "9:00 - 17:00",
            null,
            "8:00 - 16:00",
            "10:30 - 18:30",
            null,
            null,
            "7:30 - 15:30"
        ),
        listOf(
            "Eve Clarkson",
            "6:30 - 14:30",
            "8:00 - 16:00",
            "11:00 - 19:00",
            null,
            "10:00 - 18:00",
            null,
            null
        ),
        listOf(
            "Franklin Moore",
            "7:30 - 15:30",
            null,
            "8:00 - 16:00",
            null,
            null,
            "11:00 - 19:00",
            "6:30 - 14:30"
        ),
        listOf(
            "Grace Lin",
            "10:00 - 18:00",
            "7:00 - 15:00",
            null,
            null,
            "9:00 - 17:00",
            "8:30 - 16:30",
            null
        )
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(8), // Columns adjust based on screen width
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        item(span = { GridItemSpan(8) }) {
            Column(
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                NameCard("Employees")
                DayDateCard("Mon", "22")
                DayDateCard("Tue", "23")
                DayDateCard("Wed", "24")
                DayDateCard("Thu", "25")
                DayDateCard("Fri", "26")
                DayDateCard("Sat", "27")
                DayDateCard("Sun", "28")
            }
        }
        item(span = { GridItemSpan(8) }) {
            Row(
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                data.forEach { row ->
                    Column {
                        row.forEach { cell ->
                            if (cell == null) {
                                ShiftCard("", "", 0xFFdfe0dc, false, navController)
                            } else if (row.first() == cell) {
                                NameCard(cell)
                            } else {
                                ShiftCard(cell, "Clerk", 0xFFecfacf, true, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ShiftCard(
    time: String,
    position: String,
    color: Long,
    clickable: Boolean,
    navController: NavHostController
) {
    var menuVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(color))
            .clickable(clickable, onClick = { menuVisible = !menuVisible })
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            time,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
        Text(
            position,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
        DropdownMenu(
            expanded = menuVisible, onDismissRequest = { menuVisible = false }) {
            DropdownMenuItem(text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "REQUEST SWAP",
                        modifier = Modifier,
                        color = Color.Black,
                    )
                }
            }, onClick = { navController.navigate("SwapScreen") })
        }
    }
}

@Composable
fun DayDateCard(day: String, date: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFffe645))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
}

